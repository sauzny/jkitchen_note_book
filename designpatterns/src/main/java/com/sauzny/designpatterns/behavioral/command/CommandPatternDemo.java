package com.sauzny.designpatterns.behavioral.command;

import com.sauzny.designpatterns.behavioral.command.s2.Stock;
import com.sauzny.designpatterns.behavioral.command.s3.BuyStock;
import com.sauzny.designpatterns.behavioral.command.s3.SellStock;
import com.sauzny.designpatterns.behavioral.command.s4.Broker;

public class CommandPatternDemo {

	public static void main(String[] args) {
		Stock abcStock = new Stock();

		BuyStock buyStockOrder = new BuyStock(abcStock);
		SellStock sellStockOrder = new SellStock(abcStock);

		Broker broker = new Broker();
		broker.takeOrder(buyStockOrder);
		broker.takeOrder(sellStockOrder);

		broker.placeOrders();
	}
}
