package com.sauzny.jkitchen_note.files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * *************************************************************************
 * @文件名称: NewFileIO.java
 *
 * @包路径  : com.sauzny.jkitchen_note.files
 *				 
 * @版权所有: Personal xinxin (C) 2016
 *
 * @类描述:  jdk7之后读写文件
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2017年8月4日 - 上午10:06:55 
 *	
 **************************************************************************
 */
public class NewFileIO {

    @Test
    public void foo01() throws IOException{
        
        String result1 = new String(Files.readAllBytes(Paths.get("/1.doc")), StandardCharsets.UTF_8);
        String md5Str1 = DigestUtils.md5Hex(result1);
        System.out.println(md5Str1);
        
        String result2 = new String(Files.readAllBytes(Paths.get("/2.doc")), StandardCharsets.UTF_8);
        String md5Str2 = DigestUtils.md5Hex(result2);
        System.out.println(md5Str2);
        /*
        String result3 = new String(Files.readAllBytes(Paths.get("//172.16.1.23/share/yangzhanfu/gquerydemo/data/all_column.txt")), StandardCharsets.UTF_8);
        String md5Str3 = DigestUtils.md5Hex(result3);
        System.out.println(result3);
        System.out.println(md5Str3);
        */
        //System.out.println(result);
        
        // Files.write(path, content.getBytes(charset), StandardOpenOption.APPEND);
        
        Path youdaoPath = Paths.get("E:/info/youdao");
        
        File dir = new File("E:/info/youdao");
        
        NewFileIO.aa(dir);
    }
    
    
    public static void aa(File file){
        File[] files = file.listFiles();
        for(File file1 : files){
            if(file1.isDirectory()){
                System.out.println("\t"+file1.getName());
                aa(file1);
            }else{
                String fullPath = file1.getPath();
                String partName = fullPath.substring(15);
                System.out.println("\t\t["+file1.getName()+"](" + partName + ")");
            }
        }
    }
}
