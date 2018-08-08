package com.sauzny.jkitchen_note.db.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;


public class ZKClientFactory {

	private static CuratorFramework client;
	
	public static CuratorFramework getClient(){
		if(client == null){
			client = CuratorFrameworkFactory.builder()
					.connectString("192.168.48.136:2181,192.168.48.134:2181,192.168.48.135:2181").namespace("zktest")
					.retryPolicy(new RetryNTimes(2000, 20000)).build();
			client.start();
		}
		return client;
	}
}
