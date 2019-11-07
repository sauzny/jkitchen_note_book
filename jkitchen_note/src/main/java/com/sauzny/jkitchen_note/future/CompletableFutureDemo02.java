package com.sauzny.jkitchen_note.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

//import org.junit.Test;

import com.sauzny.jkitchen_note.Print;

/**
 * *************************************************************************
 * @文件名称: CompletableFutureDemo02.java
 *
 * @包路径  : com.sauzny.jkitchen_note.future
 *				 
 * @版权所有: Personal xinxin (C) 2017
 *
 * @类描述:   工厂方法，一些基本api的使用
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2017年12月28日 - 下午6:18:45 
 *	
 **************************************************************************
 */
public class CompletableFutureDemo02 {
    
    
    /**
     * 写在前面的话，这个类的api和java8中的stream风格很类似
     * 
     * CompletableFuture的api返回结果，还是CompletableFuture类型，从而形成链式的调用
     */
    
    /**
     * 
     * 一些静态测试方法
     * 
     * TestFunc.f0() 就是sleep3秒，返回 "hello0"
     * TestFunc.f1() 就是sleep3秒，返回 "hello1"
     * TestFunc.f2() 就是sleep3秒，返回 "hello2"
     * TestFunc.f3() 就是sleep3秒，返回 "hello3"
     * TestFunc.f4() 就是sleep3秒，返回 "hello4"
     */
    
    /**
     * @描述: 工厂创建实例运行
     * @返回 void
     * @创建人  ljx 创建时间 2017年12月28日 下午6:22:58
     */
    //@Test
    public void foo01(){
        
        
        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        // 执行 CompletableFuture
        CompletableFuture<String> resultCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return "hello";
        }, executor);  // 
        
        // executor 是自定义线程池，线程数量多不是必然快，但是大部分时候真的快……
        // executor 这个参数没有的话 会使用 ForkJoinPool.commonPool()，全局的，在JDK8中介绍的通用池
        
        // ForkJoinPool说两句，不说太多
        // ForkJoinPool可以用给定的目标并行级别构造；默认情况下，它等于可用处理器的数量。但是似乎因为本身线程占用1个的原因，线程池的数量还要再减1
        // ForkJoinPool可以new 也可以用别的方法修改数量
        // 修改数量 System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","20");
        
        
        // lambda 写法 
        CompletableFuture<String> resultCompletableFuture1 = CompletableFuture.supplyAsync(TestFunc::f0);
        
        // runAsync() 功能等同于 supplyAsync()，
        // 区别在于，参数需要Runnable，因此它返回CompletableFuture<Void>作为Runnable不返回任何值。
        // 也就是说，对于Future的结果你还不需要继续处理，此时可以使用runAsync()
        CompletableFuture<Void> resultCompletableFuture2 = CompletableFuture.runAsync(TestFunc::f0);
        
        // 获取结果 使用get方法
        try {
            System.out.println(resultCompletableFuture.get());
            // get方法可以设置超时
            // resultCompletableFuture.get(timeout, unit);
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 获取结果 使用join方法，在内部捕获了异常
        System.out.println(resultCompletableFuture.join());
        
        // 获取结果 使用getNow方法，执行的时候不阻塞，如果Future还没执行完，就返回默认值。
        resultCompletableFuture.getNow("默认值");
        
    }
    
    
    /**
     * @描述:三个个静态方法 anyOf allOf completedFuture
     * @返回 void
     * @创建人  ljx 创建时间 2017年12月29日 上午8:37:38
     */
    //@Test
    public void foo02(){
        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        // 创建两个Future任务
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(TestFunc::f1, executor);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(TestFunc::f2, executor);
        
        // 这两个任务都不使用 get 方法
        // 分别测试api  anyOf allOf

        CompletableFuture<Object> anyResult = CompletableFuture.anyOf(cf1,cf2);
        Print.sysoutThree("CompletableFuture.anyOf","任意一个完成，获取第一个完成的结果", anyResult.join());

        CompletableFuture<Void> allResult = CompletableFuture.allOf(cf1,cf2);

        //阻塞等待所有任务执行完成
        allResult.join();
        System.out.println("所有任务执行完成");
        

        String value = "hello world";
        CompletableFuture<String> completedFuture = CompletableFuture.completedFuture(value);

        Print.sysoutThree("CompletableFuture.completedFuture","把 一个Object给Futurte了，当测试或者写一些适配器层时可能非常有用。", completedFuture.join());
        
    }

    //@Test
    public void foo03(){
        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        // 创建两个Future任务
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(TestFunc::f1, executor);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(TestFunc::f2, executor);
        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(TestFunc::f3, executor);
        CompletableFuture<String> cf4 = CompletableFuture.supplyAsync(TestFunc::f4, executor);
        

        cf1.obtrudeValue("强制赋值");
        Print.sysoutThree("cf1.obtrudeValue","被obtrudeValue的话，会马上返回结果", cf1.join());

        Print.sysoutThree("cf2.join","输出cf2的值", cf2.join());
        cf2.obtrudeValue("强制赋值，即使future已经complete了，也要强制修改");
        Print.sysoutThree("cf2.obtrudeValue","强制赋值，即使future已经complete了，也要强制修改", cf2.join());

        //cf1.obtrudeException(强制异常);

        cf3.complete("如果现在还没有完成，则被赋值");
        Print.sysoutThree("cf3.complete","被complete的话，会马上返回结果", cf3.join());

        Print.sysoutThree("cf4.join","输出cf4的值", cf4.join());
        cf4.complete("future已经complete了，此时再赋值也没有作用了");
        Print.sysoutThree("cf4.complete","future已经complete了，此时再赋值也没有作用了", cf4.join());
        
        //cf1.completeExceptionally("如果现在还没有完成，则被赋异常");

        // return this 就是返回当前对象
        cf1.toCompletableFuture();
        
        // getNumberOfDependents 这个方法很难翻译啊……意思就是 几个层 几个单元 几个单位
        
        /*
        Print.sysoutThree("cf1.getNumberOfDependents","第几层", cf1.getNumberOfDependents());
        cf1.thenCompose(result -> cf2).thenRun(()->System.out.println(""));
        Print.sysoutThree("cf1.getNumberOfDependents","第几层", cf1.getNumberOfDependents());
        cf1.thenCompose(result -> cf3);
        cf1.thenRun(()->System.out.println(""));;
        Print.sysoutThree("cf1.getNumberOfDependents","第几层", cf1.getNumberOfDependents());
        cf1.thenCompose(result -> cf4).thenRun(()->System.out.println(""));
        Print.sysoutThree("cf1.getNumberOfDependents","第几层", cf1.getNumberOfDependents());
        */
        
        // =========自己看看API就知道啥意思了吧================
        
        //cf1.cancel(true);
        //cf1.isCancelled();
        
        //cf1.isCompletedExceptionally();

        //cf1.isDone();

    }
}
