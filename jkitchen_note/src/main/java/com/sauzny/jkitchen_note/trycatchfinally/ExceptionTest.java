package com.sauzny.jkitchen_note.trycatchfinally;

import java.util.List;

import com.google.common.collect.Lists;

public class ExceptionTest {

    public static void foo01() throws MyException1{
        throw new MyException1("1");
    }
    
    public static void foo02() throws MyException2 {
        
        try {
            ExceptionTest.foo01();
        } catch (Exception e) {
            throw new MyException2("2", e);
        }
        
        
    }
    
    public static void foo03() throws MyException3 {
        
        try {
            ExceptionTest.foo02();
        } catch (MyException2 e) {
            throw new MyException3("3", e);
        }
        
    }
    
    private static void throwableList(List<Throwable> list, Throwable cause){
        
        Throwable temp = cause.getCause();
        
        if(temp != null){
            list.add(temp);
            throwableList(list, temp);
        }
    } 
    
    public static List<Throwable> throwableList(Throwable cause){
        List<Throwable> list = Lists.newArrayList();
        throwableList(list, cause);
        return list;
    }
    
    public static void main(String[] args) throws InterruptedException {
        try {
            ExceptionTest.foo03();
        } catch (Exception e) {
            
            for(StackTraceElement stackTraceElement : e.getStackTrace()){
                System.out.println(stackTraceElement.getClassName());
            }
            System.out.println("===============================");
            for(Throwable throwable : e.getSuppressed()){
                System.out.println(throwable.getMessage());
            }
            System.out.println("===============================");
            
            
            List<Throwable> list = ExceptionTest.throwableList(e);
            System.out.println(list);
            
        }
        System.out.println("Exception必须写处理，所以不影响这行打印");
        
        Thread.sleep(1000L);
        
        throw new MyRunTimeException1("不能在下面再继续写代码了");
        
        //System.out.println("RunTimeException不用在代码中必须处理，此行代码编译不通过");
    }
}
