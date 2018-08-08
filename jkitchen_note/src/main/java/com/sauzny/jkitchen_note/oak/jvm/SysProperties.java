package com.sauzny.jkitchen_note.oak.jvm;

import java.util.Enumeration;
import java.util.TreeMap;

public class SysProperties {

    public static void main(String[] args) {
        //先获得系统属性的Properties对象，继而获得所有Property名称的枚举
        Enumeration<?> e = System.getProperties().propertyNames();
        //TreeMap是SortedMap的现阶段唯一实现，保证key有序；用来有序地保存系统属性
        TreeMap<String,String> ptmap = new TreeMap<String,String>();
        while(e.hasMoreElements()) {
            String key = (String)e.nextElement();
            String value = System.getProperty(key);
            ptmap.put(key, value);
        }
        for(String key : ptmap.keySet()) {
            //格式化输出，第一个字符串左对齐，宽30
            //System.out.format("%-30s%s", key,ptmap.get(key));
            System.out.printf("%s | %s", key,ptmap.get(key));
            System.out.println();
        }
    }
}
