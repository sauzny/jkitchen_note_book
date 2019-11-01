package com.sauzny.jkitchen_note.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;


public class AppTest {

    //@Test
    public void foo01(){
        ExecutorService service = Executors.newFixedThreadPool(20);
        
        for(int i=0; i<20; i++){
            service.execute(new WorkerA());
        }
        
        while(true){
            
        }
    }
    
    @Test
    public void foo02() throws InterruptedException, ExecutionException{
        
        final String jr = "";
        
        ExecutorService exec=Executors.newFixedThreadPool(1);
        Callable<String> task=new Callable<String>() {
            @Override
            public String call() throws Exception {
                
                try {
                        System.out.println("aa");
                    return jr;
                } catch (Throwable e) {
                    return jr;
                }  
            }
        };
        Future<String> f = exec.submit(task);
        String aa = f.get();
        long cost=0,begin=System.currentTimeMillis();
        while(!f.isDone()){
            if(cost>30000){
                break;
            }
            cost=System.currentTimeMillis()-begin;
        }
        f.cancel(true);
        exec.shutdown();
    }
}

class WorkerA implements Runnable{
    
    @Override
    public void run() {
        
        while(true){
            System.out.println(Thread.currentThread().getId());
            
            try {
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}
