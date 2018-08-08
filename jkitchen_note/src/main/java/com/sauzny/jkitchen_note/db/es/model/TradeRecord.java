package com.sauzny.jkitchen_note.db.es.model;

public class TradeRecord {

	public static enum Field{
		orderId,
		userName,
		receiveMobile,
		productId,
		curPrice,
		count,
		payTime,
		payTimeLong,
		skuDesc,
		createTime,
	}
	
	

	public TradeRecord(String orderId, String userName, String receiveMobile,
			String productId, String curPrice, String count, String payTime,
			String payTimeLong) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.receiveMobile = receiveMobile;
		this.productId = productId;
		this.curPrice = curPrice;
		this.count = count;
		this.payTime = payTime;
		this.payTimeLong = payTimeLong;
	}

	private String orderId;
	
	private String userName;
	
	private String receiveMobile;
	
	private String productId;
	
	private String curPrice;
	
	private String count;
	
	private String payTime;
	
	private String payTimeLong;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReceiveMobile() {
		return receiveMobile;
	}

	public void setReceiveMobile(String receiveMobile) {
		this.receiveMobile = receiveMobile;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCurPrice() {
		return curPrice;
	}

	public void setCurPrice(String curPrice) {
		this.curPrice = curPrice;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getPayTimeLong() {
		return payTimeLong;
	}

	public void setPayTimeLong(String payTimeLong) {
		this.payTimeLong = payTimeLong;
	}

	@Override
	public String toString() {
		return "TradeRecord [orderId=" + orderId + ", userName=" + userName
				+ ", receiveMobile=" + receiveMobile + ", productId="
				+ productId + ", curPrice=" + curPrice + ", count=" + count
				+ ", payTime=" + payTime + ", payTimeLong=" + payTimeLong + "]";
	}

	
}
