package com.sauzny.tooljdk.ip;

import java.util.Random;

public class IpUtils {

	/**
	 * 	方法描述:  生成一个随机 xx.xx.xx.xx 的IP地址
	 *   
	 *  @author  ljx 创建时间 2017年7月25日 下午2:38:48
	 */
	public static String randomIp() {
        Random r = new Random();
        StringBuffer str = new StringBuffer();
        str.append(r.nextInt(1000000) % 255);
        str.append(".");
        str.append(r.nextInt(1000000) % 255);
        str.append(".");
        str.append(r.nextInt(1000000) % 255);
        str.append(".");
        str.append(r.nextInt(1000000) % 255);

        return str.toString();
    }
}
