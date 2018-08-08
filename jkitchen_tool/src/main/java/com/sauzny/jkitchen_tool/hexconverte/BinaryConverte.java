package com.sauzny.jkitchen_tool.hexconverte;

/**
 * *************************************************************************
 * @文件名称: BinaryConverte.java
 *
 * @包路径  : com.sauzny.javaknife.hexconverte 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  二进制转换其他进制
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年9月23日 - 上午11:56:58 
 *	
 **************************************************************************
 */
public final class BinaryConverte {
    
    private BinaryConverte(){}
    
    public static String to8(String str){
        return Integer.toOctalString(Integer.valueOf(str,2));
    }
    
    public static String to10(String str){
        return Integer.valueOf(str,2).toString();
    }
    
    public static String to16(String str){
        return Integer.toHexString(Integer.valueOf(str,2));
    }
}
