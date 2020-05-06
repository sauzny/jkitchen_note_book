package com.sauzny.jkitchen_note.rmi.service;

import com.sauzny.jkitchen_note.rmi.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

// 必须声明一个接口

public interface RmiService extends Remote {

    int RMI_SERVICE_PORT = 8888;
    String RMI_SERVICE_NAME = "rmi://localhost:"+RMI_SERVICE_PORT+"/"+RmiService.class.getName();

    String helloWorld() throws RemoteException;

    User getUser() throws RemoteException;
}
