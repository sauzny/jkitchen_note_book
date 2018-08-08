package com.sauzny.jkitchen_note.db.zookeeper;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

public class CuratorManager {

	private static String zookeeperConnectionString = "192.168.48.136:2181";
	
	public void init(){
	}
	
	public static String getData(byte[] byteArray){
		String strData = null;
		try {
			strData = new String(byteArray,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return strData;
	}
	
	public static void main(String[] args) throws Exception {
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		
			
	  		CuratorFramework client = CuratorFrameworkFactory.newClient(zookeeperConnectionString, retryPolicy);
		
		
		//账户权限创建 client
		//CuratorFramework client = CuratorFrameworkFactory.builder().authorization("digest", "admin:admin123".getBytes()).connectString(zookeeperConnectionString).retryPolicy(retryPolicy).build();
		
		List<ACL> acls = new ArrayList<ACL>(2);   

		Id id1 = new Id("digest", DigestAuthenticationProvider.generateDigest("admin:admin123"));
		ACL acl1 = new ACL(ZooDefs.Perms.ALL, id1);

		Id id2 = new Id("digest", DigestAuthenticationProvider.generateDigest("guest:guest123"));
		ACL acl2 = new ACL(ZooDefs.Perms.READ, id2);

		acls.add(acl1);
		//acls.add(acl2);
/*
		ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 10000, new DefaultWatcher());
		zk.create("/test", new byte[0], acls, CreateMode.PERSISTENT);*/
		
		client.start();
		//client.getChildren().

		//创建型客户端
		//client.create().withACL(acls).forPath("/jdbc/asdadasd", "ss".getBytes("utf-8"));
		
		List<String> strList = client.getChildren().forPath("/jdbc");
		for(int i=0;i<strList.size();i++){
			System.out.print(strList.get(i)+"----");
			byte[] strData = client.getData().forPath("/jdbc/"+strList.get(i));
			System.out.println(CuratorManager.getData(strData));
		}
		
		client.close();
	}
}