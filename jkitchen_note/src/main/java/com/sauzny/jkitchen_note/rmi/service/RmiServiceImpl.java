package com.sauzny.jkitchen_note.rmi.service;

import com.sauzny.jkitchen_note.rmi.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.locks.LockSupport;

public class RmiServiceImpl extends UnicastRemoteObject implements RmiService {

    private static final long serialVersionUID = 8067795057079539791L;

    public RmiServiceImpl() throws RemoteException {
    }

    public String helloWorld() throws RemoteException {
        System.out.println("helloWorld " + Thread.currentThread().getName());
        LockSupport.parkNanos(1000*1000*1000L);
        return "Hello World!";
    }

    public User getUser() throws RemoteException {
        System.out.println("getUser " + Thread.currentThread().getName());
        LockSupport.parkNanos(1000*1000*1000L);
        return new User(1, "obama");
    }
}
