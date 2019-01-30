package com.sauzny.tooljdk.ip;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;


/**
 * *************************************************************************
 * @文件名称: LocalIpAddressUtil.java
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  	获取本机ip地址
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年9月23日 - 上午11:13:57 
 *	
 **************************************************************************
 */
public final class LocalIpAddressUtil {

	private LocalIpAddressUtil(){}
	
    /**
     * 获取本地ip地址，有可能会有多个地址, 若有多个网卡则会搜集多个网卡的ip地址
     */
    public static Set<InetAddress> resolveLocalAddresses() {
        Set<InetAddress> addrs = new HashSet<InetAddress>();
        Enumeration<NetworkInterface> ns = null;
        try {
            ns = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            // ignored...
        }
        while (ns != null && ns.hasMoreElements()) {
            NetworkInterface n = ns.nextElement();
            Enumeration<InetAddress> is = n.getInetAddresses();
            while (is.hasMoreElements()) {
                InetAddress i = is.nextElement();
                if (!i.isLoopbackAddress() && !i.isLinkLocalAddress() && !i.isMulticastAddress()
                    && !isSpecialIp(i.getHostAddress())) addrs.add(i);
            }
        }
        return addrs;
    }
    
    /**
     * 	方法描述:  	返回多个ip
     *   
     *  @author  ljx 创建时间 2016年9月23日 上午11:23:49
     */
    public static Set<String> resolveLocalIps() {
        Set<InetAddress> addrs = resolveLocalAddresses();
        Set<String> ret = new HashSet<String>();
        for (InetAddress addr : addrs)
            ret.add(addr.getHostAddress());
        return ret;
    }

    
    /**
     * 	方法描述:  获取第一个ip，如果没有返回127.0.0.1
     *   
     *  @author  ljx 创建时间 2016年9月23日 上午11:13:33
     */
    public static String resolveLocalIp(){
    	for (InetAddress inetAddress : LocalIpAddressUtil.resolveLocalAddresses()) {  
		     if(inetAddress != null){
		    	 return inetAddress.getHostAddress();
		     }
		} 
    	
    	return "127.0.0.1"; 
    }

    /**
     * 	方法描述: 特殊ip，内网之类 
     *   
     *  @author  ljx 创建时间 2016年9月23日 上午11:23:31
     */
    private static boolean isSpecialIp(String ip) {
        if (ip.contains(":")) return true;
        if (ip.startsWith("127.")) return true;
        if (ip.startsWith("192.")) return true;
        if (ip.startsWith("169.254.")) return true;
        if (ip.equals("255.255.255.255")) return true;
        return false;
    }

}
