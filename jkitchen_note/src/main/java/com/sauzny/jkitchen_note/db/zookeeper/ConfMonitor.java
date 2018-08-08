package com.sauzny.jkitchen_note.db.zookeeper;

import java.util.concurrent.ConcurrentSkipListSet;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.zookeeper.WatchedEvent;

//监听配置
public class ConfMonitor implements CuratorWatcher {

	private CuratorFramework zkClient;
	
	private String path;
	
	public ConfMonitor(CuratorFramework zkClient, String path){
		this.zkClient = zkClient;
		this.path = path;
	}
	
	@Override
	public void process(WatchedEvent event) throws Exception {
		//输出事件类别
		System.out.println(event.getType());
		
		switch (event.getType()) {
		case NodeCreated:
			
			break;
		case NodeDeleted:

			break;
		case NodeDataChanged:

			break;
		case NodeChildrenChanged:

			break;
		default:
			break;
		}
		
		zkClient.getData().usingWatcher(this).forPath(path);
	}
	
	
	/*
	 * 以下代码再其他类中实现
	 */

	//监听者集合
	private ConcurrentSkipListSet<String> watchers = new ConcurrentSkipListSet<String>();
	
	//session丢失时候，re添加监听者
	public void addReconnectionWatcher(final String path, final CuratorWatcher watcher) {
		synchronized (this) {
			// 不要添加重复的监听事件
			if (!watchers.contains(watcher.toString())){
			
				watchers.add(watcher.toString());
				System.out.println("add new watcher " + watcher);
				
				//添加监听事件
				zkClient.getConnectionStateListenable().addListener(new SessionLossListener(path, watcher));
			}
		}
	}
	
	//session丢失事件
	private class SessionLossListener implements ConnectionStateListener {
		
		private String path;
		
		private CuratorWatcher watcher;
		
		public SessionLossListener(final String path, final CuratorWatcher watcher){
			this.path = path;
			this.watcher = watcher;
		}
		
		@Override
		public void stateChanged(CuratorFramework client, ConnectionState newState) {
			System.out.println(newState);
			
		}
	}
}
