package com.sauzny.jkitchen_tool.hexconverte;

/**
 * *************************************************************************
 * @文件名称: DecimalConverte.java
 *
 * @包路径  : com.sauzny.javaknife.hexconverte 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  十进制转换器
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年9月23日 - 上午11:58:18 
 *	
 **************************************************************************
 */
public final class DecimalConverte {
    
    private DecimalConverte(){}
    
    public static String to2(int i){
        return Integer.toBinaryString(i);
    }
    
    public static String to8(int i){
        return Integer.toOctalString(i);
    }
    
    public static String to16(int i){
        return Integer.toHexString(i);
    }
}
