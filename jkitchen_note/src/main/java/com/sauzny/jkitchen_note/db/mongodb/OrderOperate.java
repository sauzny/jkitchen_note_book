package com.sauzny.jkitchen_note.db.mongodb;

public class OrderOperate extends BaseMongoEntity {

	private String orderId;
	
	private String remark;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
