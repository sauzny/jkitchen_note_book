package com.sauzny.jkitchen_note.db.mongodb;

public class MyMongoDB {

	public static void main(String[] args) {
	
		OrderOperate orderOperate = new OrderOperate();
		
		OrderOperateMongoDao OrderOperateMongoDao = new OrderOperateMongoDao();
	
		OrderOperateMongoDao.insert(orderOperate);
		
		OrderOperateMongoDao.findByOrderId("orderId");
		
	}
}
