package com.sauzny.jkitchen_note.future;

import java.util.concurrent.TimeUnit;

public class TestFunc {

    public static String f0(){
        try {  
            TimeUnit.SECONDS.sleep(3);  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return "hello0";  
    }
    
    public static String f1(){
        try {  
            TimeUnit.SECONDS.sleep(3);  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return "hello1";  
    }
    
    public static String f2(){
        try {  
            TimeUnit.SECONDS.sleep(3);  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return "hello2";  
    }
    
    public static String f3(){
        try {  
            TimeUnit.SECONDS.sleep(3);  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return "hello3";  
    }
    
    public static String f4(){
        try {  
            TimeUnit.SECONDS.sleep(3);  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return "hello4";  
    }
    
    public static String f5(String param){
        try {  
            TimeUnit.SECONDS.sleep(3);  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return param + "hello5";  
    }

    public static void 我就是一个异常(){
        // 调用的话 就会有异常了
        Integer.parseInt("我不能被数字化");
    }
    
    public static void consumer(Object arg){
        System.out.println("TestFunc consumer : " + arg);
    }
    
    
}
