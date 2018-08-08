package com.sauzny.jkitchen_tool.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * *************************************************************************
 * 
 * @文件名称: IpConvert.java
 *
 * @包路径 : com.sauzny.javaknife.ip
 *
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述: ip转换
 * 
 * @创建人: ljx
 *
 * @创建时间: 2016年9月23日 - 上午11:25:25
 *
 **************************************************************************
 */
public final class IpConvert {

    private IpConvert() {}

    /**
     * 把long类型的Ip转为一般Ip类型：xx.xx.xx.xx
     * 
     * @param ip
     * @return
     */
    public static String getIpFromLong(Long ip) {

        String s1 = String.valueOf((ip >> 24) & 0xff);
        String s2 = String.valueOf((ip >> 16) & 0xff);
        String s3 = String.valueOf((ip >> 8) & 0xff);
        String s4 = String.valueOf(ip & 0xff);
        
        return s1 + "." + s2 + "." + s3 + "." + s4;
    }

    /**
     * 把xx.xx.xx.xx类型的转为long类型的
     * 
     * @param ip
     * @return
     */
    public static Long getIpFromString(String ip) {
		int ipNum;
		try {
			ipNum = str2Ip(ip);
			return int2long(ipNum);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return 0L;
		}
    }


	public static int str2Ip(String ip) throws UnknownHostException {
		InetAddress address = InetAddress.getByName(ip);// 在给定主机名的情况下确定主机的 IP 址。
		byte[] bytes = address.getAddress();// 返回此 InetAddress 对象的原始 IP 地址
		int a, b, c, d;
		a = byte2int(bytes[0]);
		b = byte2int(bytes[1]);
		c = byte2int(bytes[2]);
		d = byte2int(bytes[3]);
		int result = (a << 24) | (b << 16) | (c << 8) | d;
		return result;
	}
	
	public static int byte2int(byte b) {
		int l = b & 0x07f;
		if (b < 0) {
			l |= 0x80;
		}
		return l;
	}
	
	public static long int2long(int i) {
		long l = i & 0x7fffffffL;
		if (i < 0) {
			l |= 0x080000000L;
		}
		return l;
	}
	
    /**
     * 方法描述: 将ip转换为定长8个字符的16进制表示形式：255.255.255.255 -> FFFFFFFF
     * 
     * @author ljx 创建时间 2016年9月23日 上午11:25:49
     */
    public static String hexIp(String ip) {
        StringBuilder sb = new StringBuilder();
        for (String seg : ip.split("\\.")) {
            String h = Integer.toHexString(Integer.parseInt(seg));
            if (h.length() == 1)
                sb.append("0");
            sb.append(h);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
		long ip = IpConvert.getIpFromString("218.206.160.57");
		System.out.println(hexIp("218.206.160.57"));
		System.out.println(ip);
		System.out.println(getIpFromLong(ip));
		
	}
}
