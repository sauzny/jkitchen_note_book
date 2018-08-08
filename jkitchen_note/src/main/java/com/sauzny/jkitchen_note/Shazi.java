package com.sauzny.jkitchen_note;

import java.time.ZoneId;
import java.util.List;

import org.springframework.util.StopWatch;

import com.google.common.collect.Lists;

public class Shazi {

    public static void main(String[] args) {
        
        System.out.println(System.currentTimeMillis());
        System.out.println(ZoneId.systemDefault());
        
        List<String> list = Lists.newArrayList();
        
        for(int i=0;i<1000000;i++){
            list.add("");
        }

        StopWatch clock = new StopWatch("傻子, 1000000");
        
        clock.start("String i : list");
        
        for(String i : list){
            
        }

        clock.stop();
        clock.start("int i=0;i<list.size();i++");
        
        for(int i=0;i<list.size();i++){
            
        }

        clock.stop();
        System.out.println(clock.prettyPrint());
    }
}
