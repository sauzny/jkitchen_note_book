package com.sauzny.jkitchen_note.db.zookeeper;

import org.apache.curator.framework.CuratorFramework;

public class WatcherWorker extends Thread{

	@Override
	public void run() {
		
		CuratorFramework client = ZKClientFactory.getClient();
		
		ConfMonitor confMonitor = new ConfMonitor(client, "zk");
		
		try {
			client.getData().usingWatcher(confMonitor).forPath("zk");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true){
		}
	}
}
