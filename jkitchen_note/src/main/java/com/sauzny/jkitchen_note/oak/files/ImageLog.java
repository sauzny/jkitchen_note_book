package com.sauzny.jkitchen_note.oak.files;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class ImageLog {

    private static void fx(){
        try {
            
            // 预定义结果
            Map<String, List<String>> image_result = new HashMap<String, List<String>>();
            Map<String, Integer> result_count = new HashMap<String, Integer>();
            
            // 读取文件 计算结果
            List<String> lineList = FileUtils.readLines(new File("C:/Users/user/Desktop/all.2016-09-22.log"), "utf-8");
            for(String line : lineList){
                
                if(line.indexOf("ac112a01ite7tk4g-")>0){
                    String rid = line.substring(85).split(" >>> ")[0];
                    List<String> resultList = new ArrayList<String>();
                    
                    String tags = line.substring(85).split(" >>> ")[1].split("tags=")[1].replace(", toString()=FeignBaseResult(status=200, msg=null)]]","");
                    if(tags.length() > 10){
                        String[] tagStrs = tags.replace("[","").replace("]","").split(",");
                        for(String tag : tagStrs){
                            if (tag.indexOf("label=") > 0){
                                resultList.add(tag.split("=")[1]);
                            }
                        }
                    }else{
                        resultList.add("无结果");
                    }
                    
                    // 
                    image_result.put(rid, resultList);
                    
                    for(String result : resultList){
                        if(result_count.get(result) == null){
                            result_count.put(result, 1);
                        }else{
                            result_count.put(result, result_count.get(result)+1);
                        }
                    }
                    
                }
                
            }
            
            System.out.println(image_result.get("ac112a01ite7tk4g-32150"));
            System.out.println(result_count.get("删"));
        
            List<String> image_result_content = new ArrayList<String>();
            List<String> result_count_content = new ArrayList<String>();
            
            for(String key : image_result.keySet()){
                String content = key + "\t" + image_result.get(key).toString();
                image_result_content.add(content);
            }
            
            for(String key : result_count.keySet()){
                String content = key + "\t" + result_count.get(key).toString();
                result_count_content.add(content);
            }
            FileUtils.writeLines(new File("C:/Users/user/Desktop/image_result.txt"), image_result_content, true);
            FileUtils.writeLines(new File("C:/Users/user/Desktop/result_count.txt"), result_count_content, true);
            
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        fx();

    }

}
