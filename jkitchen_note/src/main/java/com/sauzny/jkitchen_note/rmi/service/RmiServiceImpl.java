package com.sauzny.jkitchen_note.rmi.service;

import com.sauzny.jkitchen_note.rmi.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiServiceImpl extends UnicastRemoteObject implements RmiService {

    private static final long serialVersionUID = 8067795057079539791L;

    public RmiServiceImpl() throws RemoteException {
    }

    public String helloWorld() throws RemoteException {
        return "Hello World!";
    }

    public User getUser() throws RemoteException {
        return new User(1, "obama");
    }
}
