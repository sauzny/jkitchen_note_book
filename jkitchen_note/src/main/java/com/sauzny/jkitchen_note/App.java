package com.sauzny.jkitchen_note;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.elasticsearch.common.collect.Lists;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;

/**
 * Hello world!
 *
 */
public class App {
    
    public List<String> listapp;
    
    public static void main(String[] args) throws UnknownHostException, IOException{
        
        StringBuilder  builder = new StringBuilder();   

        System.out.println(builder.hashCode());
        System.out.println(builder == null);
        
        System.getProperty("java.io.tmpdir");
        
        File file = new File("");
        
        System.out.println(File.separator);
        
        System.out.println("13399990000".replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
        
        System.out.println(null == null ? 1 : 2);
        
        System.out.println(UUID.randomUUID());
        
        List<String> list01 = Lists.newArrayList(
                "`fact_persion` table_02 inner join `sex` table_11 on `table_02`.`p_sex`=`table_11`.`id`",
                "`fact_persion` table_02 inner join `medal_type` table_06 on `table_02`.`medal_type`=`table_06`.`id`");
        
        
        int[] ints = {1,2,3};
        String[] strs = {"","",""};
        // <int[]> List<int[]> java.util.Arrays.asList(int[]... a)
        Arrays.asList(ints);
        Arrays.asList(strs);
        

        Ints.asList(ints);
        
        Set<String> a = Sets.newHashSet("a","b","c");
        Set<String> b = Sets.newHashSet("a","b","c");
        
        System.out.println(b.containsAll(a));
        
        List<Integer> list1 = Lists.newArrayList(1,2,3);
        List<String> list2 = null;
        
        Print.sysout("list是否为空{}", Iterables.isEmpty(list1));
        
        Collections.emptyList();
        
        System.out.println(list1);
        list1.add(0, 4);
        System.out.println(list1);

    }
    
    
    
}
