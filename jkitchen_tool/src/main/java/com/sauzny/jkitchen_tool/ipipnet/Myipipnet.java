package com.sauzny.jkitchen_tool.ipipnet;

import java.util.Arrays;

import com.sauzny.jkitchen_tool.ip.IpUtils;
import com.sauzny.jkitchen_tool.math.MathUtils;

/**
 * *************************************************************************
 * @文件名称: Myipipnet.java
 *
 * @包路径  : com.sauzny.jkitchen_tool.ipipnet 
 *				 
 * @版权所有: Personal xinxin (C) 2016
 *
 * @类描述:  ipipnet 测试类
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2017年7月25日 - 下午2:40:07 
 *	
 **************************************************************************
 */
public class Myipipnet {

	public static void main(String[] args) {
		
		//IP.enableFileWatch = false; // 默认值为：false，如果为true将会检查ip库文件的变化自动reload数据

		IP.load("17monipdb.dat");
		
		long total = 0L;
		
		Integer[] hs = new Integer[100];
		
		for(int i=0; i<100; i++){
			
			String ip = IpUtils.randomIp();
			
			long a = System.nanoTime();
			
			String[] address = IP.find(ip);
			
			long b = System.nanoTime();
			
			Long current = b-a;
			
			total += current;
			
			hs[i] = current.intValue();
			
			System.out.println(current + "纳秒 -- " + ip + " -- " + Arrays.toString(address));
		}
		
		System.out.println("总耗时：" + total + "纳秒 平均耗时：" + (total/100) + "纳秒 中位数：" + MathUtils.medianNum(hs) + "纳秒");
		
	}
}
