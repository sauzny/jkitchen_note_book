package com.sauzny.jkitchen_note;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
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
        
    	System.out.println(new Date());
    	
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
        

        System.out.println("13/8 = " + (13 >> 3) );
        System.out.println("13%8 = " + (13 & (1<<3)-1) );

        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);

        /**
         * Twitter_Snowflake<br>
         * SnowFlake 的结构如下(每部分用-分开):<br>
         * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000 <br>
         * 1 位标识，由于 long 基本类型在 Java 中是带符号的，最高位是符号位，正数是 0，负数是 1，所以 id 一般是正数，最高位是 0<br>
         * 41 位时间截(毫秒级)，注意，41 位时间截不是存储当前时间的时间截，而是存储时间截的差值（当前时间截 - 开始时间截)
         * 得到的值），这里的的开始时间截，一般是我们的 id 生成器开始使用的时间，由我们程序来指定的（如下下面程序 IdWorker 类的 startTime 属性）。41 位的时间截，可以使用 69 年，年 T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
         * 10 位的数据机器位，可以部署在 1024 个节点，包括 5 位 datacenterId 和 5 位 workerId<br>
         * 12 位序列，毫秒内的计数，12 位的计数顺序号支持每个节点每毫秒(同一机器，同一时间截)产生 4096 个 ID 序号<br>
         * 加起来刚好 64 位，为一个 Long 型。<br>
         * SnowFlake 的优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生 ID 碰撞(由数据中心 ID 和机器 ID 作区分)，并且效率较高，经测试，SnowFlake 每秒能够产生 26 万 ID 左右。
         */
    }
    
    
    
}
