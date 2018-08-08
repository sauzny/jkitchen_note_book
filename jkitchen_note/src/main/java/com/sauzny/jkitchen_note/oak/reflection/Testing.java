package com.sauzny.jkitchen_note.oak.reflection;

import java.lang.reflect.Method;

import org.springframework.util.StopWatch;

public class Testing {

    public static void main(String[] args) throws Exception {
        
        Target target = new Target();
        
        Method foo = Target.class.getMethod("product", null);
        
        Object obj = foo.invoke(target, null);
        System.out.println(obj);
        
        Product product = target.product();
        System.out.println(product);
        

        StopWatch clock100 = new StopWatch("百次");
        clock100.start("invoke");
        for(int i=0;i<100;i++) foo.invoke(target, null);
        clock100.stop();
        clock100.start("target");
        for(int i=0;i<100;i++) target.product();
        clock100.stop();
        System.out.println(clock100.prettyPrint());
        

        StopWatch clock10000 = new StopWatch("万次");
        clock10000.start("invoke");
        for(int i=0;i<10000;i++) foo.invoke(target, null);
        clock10000.stop();
        clock10000.start("target");
        for(int i=0;i<10000;i++) target.product();
        clock10000.stop();
        System.out.println(clock10000.prettyPrint());
        

        StopWatch clock1000000 = new StopWatch("百万次");
        clock1000000.start("invoke");
        for(int i=0;i<1000000;i++) foo.invoke(target, null);
        clock1000000.stop();
        clock1000000.start("target");
        for(int i=0;i<1000000;i++) target.product();
        clock1000000.stop();
        System.out.println(clock1000000.prettyPrint());

        
        StopWatch clock100000000 = new StopWatch("亿次");
        clock100000000.start("invoke");
        for(int i=0;i<100000000;i++) foo.invoke(target, null);
        clock100000000.stop();
        clock100000000.start("target");
        for(int i=0;i<100000000;i++) target.product();
        clock100000000.stop();
        System.out.println(clock100000000.prettyPrint());
        
    }
}
