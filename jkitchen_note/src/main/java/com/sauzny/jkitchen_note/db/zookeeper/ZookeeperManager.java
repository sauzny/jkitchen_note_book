package com.sauzny.jkitchen_note.db.zookeeper;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * *************************************************************************
 * @文件名称: ZookeeperManager.java
 *
 * @包路径  : org.ljx.zookeeper 
 *				 
 * @版权所有: xxx888（北京）科技有限公司 (C) 2014
 *
 * @类描述:  ZookeeperManager
 * 
 * @创建人:   liujinxin  
 *
 * @创建时间: 2014年4月15日 - 下午6:00:28 
 *
 * @修改记录:
   -----------------------------------------------------------------------------------------------
             时间						|		修改人		|		修改的方法		|		修改描述                                                                
   -----------------------------------------------------------------------------------------------
							|					|					|                                       
   ----------------------------------------------------------------------------------------------- 	
 
 **************************************************************************
 */
public class ZookeeperManager {
	
	//超时时间
	private static final int SESSION_TIMEOUT = 30000;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperManager.class);
	
	public static ZooKeeper zooKeeper;
	
	/**
	 *  Function:获取节点的value
	 *  功能说明：
	 *	 使用说明：
	 *  @author  liujinxin  DateTime 2014年4月15日 下午6:13:19
	 *	 返回类型: String    
	 *  @return
	 */
	public static String getData(String node){
		try {
			zooKeeper = new ZooKeeper("192.168.10.57:2181", SESSION_TIMEOUT, null);
			return new String(zooKeeper.getData(node, null, null));
		} catch (IOException e) {
			LOGGER.info("连接zookeeper失败！",e.getMessage());
			return null;
		} catch (KeeperException | InterruptedException e) {
			LOGGER.info("获取节点数据失败！",e.getMessage());
			return null;
		} finally {
			try {
				zooKeeper.close();
			} catch (InterruptedException e) {
				LOGGER.info("关闭zookeeper失败！",e.getMessage());
			}
		}
	}
	
	/**
	 *  Function:获取节点的value并设置watch
	 *  功能说明：
	 *	 使用说明：
	 *  @author  liujinxin  DateTime 2014年4月15日 下午6:14:08
	 *	 返回类型: String    
	 *  @return
	 */
	public static String getDataWatch(){
		return null;
	}
	
	/**
	 *  Function:
	 *  功能说明：
	 *	 使用说明：
	 *  @author  liujinxin  DateTime 2014年4月15日 下午6:56:50
	 *	 返回类型: List<String>    
	 *  @return
	 */
	public static List<String> getChildren(String node){
		try {
			zooKeeper = new ZooKeeper("192.168.10.57:2181", SESSION_TIMEOUT, null);
			return zooKeeper.getChildren(node, true);
		} catch (IOException e) {
			LOGGER.info("连接zookeeper失败！",e.getMessage());
			return null;
		} catch (KeeperException | InterruptedException e) {
			LOGGER.info("获取节点失败！",e.getMessage());
			return null;
		} finally {
			try {
				zooKeeper.close();
			} catch (InterruptedException e) {
				LOGGER.info("关闭zookeeper失败！",e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(ZookeeperManager.getData(""));
	}
}
