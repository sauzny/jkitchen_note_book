package com.sauzny.designpatterns.behavioral.command.s4;

import java.util.ArrayList;
import java.util.List;

import com.sauzny.designpatterns.behavioral.command.s1.Order;

public class Broker {

	private List<Order> orderList = new ArrayList<Order>();

	public void takeOrder(Order order) {
		orderList.add(order);
	}

	public void placeOrders() {
		for (Order order : orderList) {
			order.execute();
		}
		orderList.clear();
	}
}
