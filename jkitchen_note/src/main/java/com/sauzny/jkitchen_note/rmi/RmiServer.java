package com.sauzny.jkitchen_note.rmi;

import com.sauzny.jkitchen_note.rmi.service.RmiServiceManager;

public class RmiServer {

    public static void main(String[] args) {
        RmiServiceManager.startService();
    }
}
