package com.sauzny.tooljdk.hexconverte;

/**
 * *************************************************************************
 * @文件名称: OctalConverte.java
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  八进制转换器
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年9月23日 - 上午11:58:42 
 *	
 **************************************************************************
 */
public final class OctalConverte {
    
    private OctalConverte(){}

    
    public static String to2(String str){
        return Integer.toBinaryString(Integer.valueOf(str,8));
    }
    
    public static String to10(String str){
        return Integer.valueOf(str,8).toString();
    }
    
    public static String to16(String str){
        return Integer.toHexString(Integer.valueOf(str,8));
    }
    
}
