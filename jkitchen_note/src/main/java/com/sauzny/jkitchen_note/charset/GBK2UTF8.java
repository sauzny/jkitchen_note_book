package com.sauzny.jkitchen_note.charset;

import com.google.common.collect.Lists;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GBK2UTF8 {

    public static List<Byte> String2ByteList(String str, String charsetName){
        List<Byte> result = Lists.newArrayList();
        try {
            for(Byte b : str.getBytes(charsetName)){
                result.add(b);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String chinese = "汉字";//java内部编码
        System.out.println("chinese : " + chinese + GBK2UTF8.String2ByteList(chinese, "ISO-8859-1"));
        System.out.println("chinese : " + chinese + GBK2UTF8.String2ByteList(chinese, "GBK"));
        System.out.println("chinese : " + chinese + GBK2UTF8.String2ByteList(chinese, "UTF-8"));

        String gbkChinese = new String(chinese.getBytes("GBK"),"ISO-8859-1");//转换成gbk编码
        System.out.println("gbkChinese : " + gbkChinese + GBK2UTF8.String2ByteList(gbkChinese, "ISO-8859-1"));//乱码

        String unicodeChinese = new String(gbkChinese.getBytes("ISO-8859-1"),"GBK");//java内部编码
        System.out.println("unicodeChinese : " + unicodeChinese + GBK2UTF8.String2ByteList(unicodeChinese, "GBK"));//中文

        String utf8Chinese = new String(unicodeChinese.getBytes("UTF-8"),"ISO-8859-1");//utf--8编码
        System.out.println("utf8Chinese : " + utf8Chinese + GBK2UTF8.String2ByteList(utf8Chinese, "ISO-8859-1"));//乱码

        unicodeChinese = new String(utf8Chinese.getBytes("ISO-8859-1"),"UTF-8");//java内部编码
        System.out.println("unicodeChinese : " + unicodeChinese + GBK2UTF8.String2ByteList(unicodeChinese, "UTF-8"));//中文
    }
}
