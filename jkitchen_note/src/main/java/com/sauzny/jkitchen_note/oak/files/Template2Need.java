package com.sauzny.jkitchen_note.oak.files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Template2Need {

    public static void main(String[] args) {
        
        String qihao = "2017096";
        String yuce = "2,3,6,8,7,15,12";
        String shiji = "2,3,6,8,7,15,12";
        try {
            List<String> lines = Files.readAllLines(Paths.get(System.getProperty("user.dir")+File.separator+"ssq.html"), StandardCharsets.UTF_8);
            
            for(int i=0;i<lines.size();i++){
                String line = lines.get(i);
                if(line.contains("${qihao}")){
                    String newLine = line.replace("${qihao}", qihao);
                    lines.set(i, newLine);
                }
                if(line.contains("${yuce}")){
                    String newLine = line.replace("${yuce}", yuce);
                    lines.set(i, newLine);
                }
                if(line.contains("${shiji}")){
                    String newLine = line.replace("${shiji}", shiji);
                    lines.set(i, newLine);
                }
            }
            Files.write(Paths.get("E:\\code\\github\\sauzny\\sauzny.github.io\\ext\\ssq\\ssq"+qihao+".html"), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
