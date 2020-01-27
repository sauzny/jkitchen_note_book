package com.sauzny.jkitchen_note.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WatchWorks {

    @Test
    public void foo01(){
        
        ExecutorService serviceWork = Executors.newFixedThreadPool(2);
        
        for(int i=0;i<10;i++){
            serviceWork.execute(new Work());
        }
        
        while(true){
            
        }
        
    }
}

class Work extends Thread{
    public void run() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Work : " + Thread.currentThread().getId());
    }
}