package com.sauzny.jkitchen_note.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import org.junit.Test;

import com.sauzny.jkitchen_note.Print;

/**
 * *************************************************************************
 * @文件名称: CompletableFutureDemo04.java
 *
 * @包路径  : com.sauzny.jkitchen_note.future
 *				 
 * @版权所有: Personal xinxin (C) 2017
 *
 * @类描述:   异常处理的对比
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2017年12月29日 - 下午3:01:45 
 *	
 **************************************************************************
 */
public class CompletableFutureDemo04 {

    /**
     * 这三个方法都能处理异常，
     *                  参数                                                              处理过程                                                                    
     * handle           result,exception       可以处理正确结果，和异常两种逻辑的代码         
     * whenComplete     result,exception       可以记录正确结果，和异常两种逻辑的代码
     * exceptionally    exception              只能处理异常
     */
    
    /**
     * @描述: future执行过程中出现的异常，处理，能接收上一步结果和异常，可编写结果和异常的处理逻辑，影响返回结果
     * @返回 void
     * @创建人  ljx 创建时间 2017年12月29日 下午2:32:19
     */
    //@Test
    public void test_handle(){

        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            TestFunc.我就是一个异常();
            return TestFunc.f1();
        }, executor);
        
        CompletableFuture<String> result_handle = cf1.handle((result, ex) -> {
            if(ex != null){
                System.out.println(ex.getMessage());
                return "异常了";
            }else{
                return result;
            }
        });
        
        // cf1.handleAsync(fn);
        // cf1.handleAsync(fn, executor);
        
        Print.sysoutThree("handle","在future执行过程中出现的异常时的判断处理", result_handle.join());

    }
    
    /**
     * @描述: 因为其参数是BiConsumer，所以能接收上一步结果和异常，但是不会影响返回结果
     * @返回 void
     * @创建人  ljx 创建时间 2017年12月29日 下午3:17:04
     */
    //@Test
    public void test_whenComplete(){
                
        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            TestFunc.我就是一个异常();
            return TestFunc.f1();
        }, executor);
        
        CompletableFuture<String> result_whenComplete = cf1.whenComplete((result, ex) -> {
            System.out.println(result);
            System.out.println(ex.getMessage());
        });
        
        // cf1.whenCompleteAsync(action);
        // cf1.whenCompleteAsync(action, executor);
        
        Print.sysoutThree("whenComplete","在future执行过程中出现的异常时的判断处理", result_whenComplete.join());
    }
    
    /**
     * @描述: exceptionally，只能处理异常，不能处理上一步的结果
     * @返回 void
     * @创建人  ljx 创建时间 2017年12月29日 下午1:49:48
     */
    //@Test
    public void test_exceptionally(){
        
        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        // future中没有异常的时候
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> TestFunc.f1(), executor);
        CompletableFuture<String> safe1 = cf1.exceptionally(ex -> "We have a problem: " + ex.getMessage());  
        System.out.println(safe1.join());
        
        // future中有异常的时候
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            TestFunc.我就是一个异常();
            return TestFunc.f2();
        }, executor);
        CompletableFuture<String> safe2 = cf2.exceptionally(ex -> "We have a problem: " + ex.getMessage());  
        System.out.println(safe2.join());
        
        
        // exceptionally 更加灵活的方法是handle()
    }
}
