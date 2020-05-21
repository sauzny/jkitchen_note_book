package com.sauzny.jkitchen_note.rmi;

import com.sauzny.jkitchen_note.rmi.service.CustomeSocketFactory;
import com.sauzny.jkitchen_note.rmi.service.RmiServiceManager;

import java.io.IOException;
import java.rmi.server.RMISocketFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RmiClient {

    private static void noConcurrent(RmiServiceManager rmiServiceManager){

        // 顺序无并发测试
        System.out.println(rmiServiceManager.helloWorld());
        System.out.println(rmiServiceManager.getUser());
        System.out.println(rmiServiceManager.helloWorld());
        System.out.println(rmiServiceManager.getUser());
        System.out.println(rmiServiceManager.helloWorld());
        System.out.println(rmiServiceManager.getUser());
        System.out.println(rmiServiceManager.helloWorld());
        System.out.println(rmiServiceManager.getUser());
    }

    private static void concurrent(RmiServiceManager rmiServiceManager){
        ExecutorService es = Executors.newFixedThreadPool(10);

        for(int i=0; i<10; i++){
            es.execute(rmiServiceManager::helloWorld);
            //es.execute(() -> System.out.println(rmiServiceManager.helloWorld()));
            //es.execute(() -> System.out.println(rmiServiceManager.getUser()));
        }

    }

    public static void main(String[] args){
        try {
            RMISocketFactory.setSocketFactory(new CustomeSocketFactory());
        } catch (IOException e) {
            e.printStackTrace();
        }
        RmiServiceManager rmiServiceManager = new RmiServiceManager();

        // 顺序无并发测试
        //RmiClient.noConcurrent(rmiServiceManager);

        // 并发测试
        RmiClient.concurrent(rmiServiceManager);

        // 两次测试对比

        // 无并发
        // - client 只在开始的时候 创建了一个 socket
        // - server 只使用一个线程处理请求

        // 并发
        // - client 创建了多个 socket
        // - server 创建了多个 socket
    }
}
