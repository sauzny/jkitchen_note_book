package com.sauzny.jkitchen_note.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

public class DoLog {

    @Test
    public void foo01(){
        try {
            
            List<String> lines = Files.readAllLines(Paths.get("E:/data/log/mqwebtesting/wsc1.2017-09-15.0.log"));
        
            ListMultimap<String, String> listMultimap = ArrayListMultimap.create();
            
            for(String line : lines){
                String key = line.substring(0, 19);
                String value = line;
                listMultimap.put(key, value);
            }
            
            int totalCount = 0;
            List<String> elementList = Lists.newArrayList();
            List<Integer> countList = Lists.newArrayList();
            
            Set<String> ketSet = new TreeSet<String>(listMultimap.keySet());

            Multiset<String> multiset = listMultimap.keys();
            for(String key : ketSet){
                elementList.add("'"+key.split(" ")[1]+"'");
                int tempCount = multiset.count(key);
                countList.add(tempCount);
                totalCount+=tempCount;
            }
            
        
            //System.out.println(totalCount);
            System.out.println(elementList);
            System.out.println(countList);
            System.out.println("QPS: "+ totalCount/listMultimap.keySet().size());
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void foo02(){
        String str = RandomStringUtils.randomAlphabetic(600*1024);
        List<String> list = Lists.newArrayList();
        list.add(str);
        try {
            Files.write(Paths.get("E:/data/aaa.txt"), list);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
