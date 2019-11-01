package com.sauzny.jkitchen_note.files;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.elasticsearch.common.collect.Lists;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ShiLiuMB {

    @Test
    public void foo01() throws Exception{
        
        List<String> list = Lists.newArrayList();
        
        for(int i=0;i<100000;i++){  
            String value = RandomStringUtils.randomAlphabetic(128);
            list.add(value);
        }

        ObjectMapper mapper = new ObjectMapper();
        // 序列化用时 60ms
        
        long a = System.currentTimeMillis();
        
        //String jsonlist = mapper.writeValueAsString(list);
        
        String jsonlist = list.toString();
        
        long b = System.currentTimeMillis();

        System.out.println(b-a);
        
        // 用时 60ms 占用12.3M
        Files.write(Paths.get("E:\\ShiLiuMB.txt"), list, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        
        // 用时 55ms
        Files.readAllLines(Paths.get("E:\\ShiLiuMB.txt"), StandardCharsets.UTF_8);
        
    }
}
