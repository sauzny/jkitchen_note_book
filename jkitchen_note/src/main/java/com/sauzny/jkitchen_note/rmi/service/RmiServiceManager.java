package com.sauzny.jkitchen_note.rmi.service;

import com.sauzny.jkitchen_note.rmi.User;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiServiceManager implements RmiService{

    public static void startService(){
        try {

            // 本地主机上的远程对象注册表Registry的实例，并指定端口为8888，
            // 这一步必不可少（Java默认端口是1099），必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上
            LocateRegistry.createRegistry(RmiService.RMI_SERVICE_PORT);

            //绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的）
            // rebind() 方法，它相当于先后调用 Naming 的 unbind() 与 bind() 方法
            Naming.rebind(RmiService.RMI_SERVICE_NAME, new RmiServiceImpl());
            //Naming.bind("rmi://localhost:8888/rmiService", rmiService);
            //Naming.bind("//localhost:8888/rmiService", rmiService);

            System.out.println(">>>>>INFO:远程rmiService绑定成功！");
        } catch (RemoteException e) {
            System.out.println("创建远程对象发生异常！");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("发生URL畸形异常！");
            e.printStackTrace();
        }
    }

    private RmiService rmiService;

    public RmiServiceManager(){
        try {
            //在RMI服务注册表中查找名称为 RmiService.RMI_SERVICE_NAME 的对象，并调用其上的方法
            this.rmiService = (RmiService) Naming.lookup(RmiService.RMI_SERVICE_NAME);
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String helloWorld() {
        try {
            return rmiService.helloWorld();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUser() {
        try {
            return rmiService.getUser();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
