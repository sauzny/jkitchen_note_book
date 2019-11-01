package com.sauzny.jkitchen_note.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureDemo {

    public void foo01(){
        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        Future<String> result = executor.submit(() -> {  
            TimeUnit.SECONDS.sleep(3);  
            return "hello";  
        });  
        
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
