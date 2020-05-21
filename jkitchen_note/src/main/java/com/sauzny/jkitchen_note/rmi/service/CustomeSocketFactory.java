package com.sauzny.jkitchen_note.rmi.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

public class CustomeSocketFactory extends RMISocketFactory {


    //指定通信端口，防止被防火墙拦截


    @Override

    public ServerSocket createServerSocket(int port) throws IOException {

        // TODO Auto-generated method stub

        if (port == 0) {

            port = 18051;

        }

        ServerSocket ss = new ServerSocket(port);
        System.out.println(ss.hashCode() + " " + Thread.currentThread().getName() + " rmi notify port : " + port);

        return ss;

    }


    @Override

    public Socket createSocket(String host, int port) throws IOException {

        // TODO Auto-generated method stub
        Socket socket = new Socket(host, port);

        System.out.println(socket.hashCode() + " " + Thread.currentThread().getName() + " createSocket host : " + host + " port : " + port);
        System.out.println();

        return socket;

    }



}
