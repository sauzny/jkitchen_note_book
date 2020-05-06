package com.sauzny.jkitchen_note.rmi;

import com.sauzny.jkitchen_note.rmi.service.RmiServiceManager;

public class RmiClient {

    public static void main(String[] args){
        RmiServiceManager rmiServiceManager = new RmiServiceManager();
        System.out.println(rmiServiceManager.helloWorld());
        System.out.println(rmiServiceManager.getUser());
    }
}
