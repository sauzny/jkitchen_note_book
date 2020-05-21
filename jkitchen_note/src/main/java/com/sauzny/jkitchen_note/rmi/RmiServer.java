package com.sauzny.jkitchen_note.rmi;

import com.sauzny.jkitchen_note.rmi.service.CustomeSocketFactory;
import com.sauzny.jkitchen_note.rmi.service.RmiServiceManager;


import java.io.IOException;
import java.rmi.server.RMISocketFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class RmiServer {

    public static void main(String[] args) {

        /**
         * sun.rmi.transport.tcp.TCPTransport
         *
         * 此类中实现了线程池，使server端，多线程接收并处理数据
         *
         */

        //查看rmiserver最大线程数
        int maxConnectionThreads =     // default no limit
                AccessController.doPrivileged((PrivilegedAction<Integer>) () ->
                        Integer.getInteger("sun.rmi.transport.tcp.maxConnectionThreads",
                                Integer.MAX_VALUE));
        System.out.println("rmi server最大线程数 : " + maxConnectionThreads);

        try {
            RMISocketFactory.setSocketFactory(new CustomeSocketFactory());
        } catch (IOException e) {
            e.printStackTrace();
        }

        RmiServiceManager.startService();
    }
}
