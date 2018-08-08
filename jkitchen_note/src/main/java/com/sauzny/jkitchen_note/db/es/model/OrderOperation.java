package com.sauzny.jkitchen_note.db.es.model;

public class OrderOperation {
	
	public OrderOperation(String orderId, String optorType, String optorId,
			String orderState, String optType, String optContent,
			String optTime, Long optTimeLong, String createTime) {
		super();
		this.orderId = orderId;
		this.optorType = optorType;
		this.optorId = optorId;
		this.orderState = orderState;
		this.optType = optType;
		this.optContent = optContent;
		this.optTime = optTime;
		this.optTimeLong = optTimeLong;
		this.createTime = createTime;
	}

	public static enum Field{
		orderId,
		optorType,
		optorId,
		orderState,
		optType,
		optContent,
		optTime,
		optTimeLong,
		createTime,
	}

	private String orderId;
	
	private String optorType;
	
	private String optorId;
	
	private String orderState;
	
	private String optType;
	
	private String optContent;

	private String optTime;
	
	private Long optTimeLong;
	
	private String createTime;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOptorType() {
		return optorType;
	}

	public void setOptorType(String optorType) {
		this.optorType = optorType;
	}

	public String getOptorId() {
		return optorId;
	}

	public void setOptorId(String optorId) {
		this.optorId = optorId;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	public String getOptContent() {
		return optContent;
	}

	public void setOptContent(String optContent) {
		this.optContent = optContent;
	}

	public String getOptTime() {
		return optTime;
	}

	public void setOptTime(String optTime) {
		this.optTime = optTime;
	}

	public Long getOptTimeLong() {
		return optTimeLong;
	}

	public void setOptTimeLong(Long optTimeLong) {
		this.optTimeLong = optTimeLong;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
