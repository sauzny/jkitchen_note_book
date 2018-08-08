package com.sauzny.jkitchen_note.db.mongodb;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;

public class OrderOperateMongoDao extends BaseMongoDao<OrderOperate>{

	public List<OrderOperate> findByOrderId(String orderId){
		Criteria criteria = Criteria.where("orderId").is(orderId);
		return this.find(criteria);
	}
}
