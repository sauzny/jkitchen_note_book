package com.sauzny.tooljdk.hexconverte;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * *************************************************************************
 * @文件名称: HexadecimalConverte.java
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  十六进制转换器
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年9月23日 - 上午11:58:31 
 *	
 **************************************************************************
 */
public final class HexadecimalConverte {
    
    private HexadecimalConverte(){}
    

    public static String to2(String str){
        return Integer.toBinaryString(Integer.valueOf(str,16));
    }
    
    public static String to10(String str){
        return Integer.valueOf(str,16).toString();
    }
    
    public static String to8(String str){
        return Integer.toOctalString(Integer.valueOf(str,16));
    }
    
    public static String toStringUTF8(String s){
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "UTF-8");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }
    
    public static void main(String[] args) throws UnsupportedEncodingException {
        String arg = "66 75 6e 43 61 6c 6c";
        Arrays.asList(arg.split(" ")).forEach(str -> System.out.print(HexadecimalConverte.toStringUTF8(str)));
        
        System.out.println();
        
        int a1 = 106;
        a1=a1&~1;
        System.out.println(a1);
        
        int a = 7;
        int b = 9;

        System.out.println("a=" + a + " b=" + b);
        
        a=a^b;
        b=b^a;
        a=a^b;

        System.out.println("a=" + a + " b=" + b);
        
        
        System.out.println(0x000000ff);
        System.out.println((byte)(0xff & (897623478 >> 8)));
        System.out.println((byte)(0xff & (897623478)));
        
        
        String str66 = new String(new byte[]{(byte) (0xff & 0x66)}, "UTF-8");
        
        System.out.println(str66);
        
        int i32 = 897623478;
        
        byte[] i32out = new byte[4];
        i32out[0] = (byte)(0xff & (i32 >> 24));
        i32out[1] = (byte)(0xff & (i32 >> 16));
        i32out[2] = (byte)(0xff & (i32 >> 8));
        i32out[3] = (byte)(0xff & (i32));
    }
}
