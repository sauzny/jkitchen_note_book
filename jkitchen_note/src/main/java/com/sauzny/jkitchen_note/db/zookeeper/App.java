package com.sauzny.jkitchen_note.db.zookeeper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 * 
 */
public class App {
	
	public static final String targetPath = "zk/test";
	
	/*
	 * 需求，开启一个线程，监听zk里的节点
	 * 
	 */
	
	public static void main(String[] args) throws Exception {
		
		ExecutorService exec = Executors.newFixedThreadPool(5); 
		exec.execute(new WatcherWorker());
		//test.create();
		//System.out.println();
		//test.put();
		//test.get();
		//test.register();
		//保持长连接
		//Thread.sleep(Long.MAX_VALUE);
		
		
	}
}

