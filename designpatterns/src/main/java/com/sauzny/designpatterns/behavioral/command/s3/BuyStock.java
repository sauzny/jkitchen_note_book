package com.sauzny.designpatterns.behavioral.command.s3;

import com.sauzny.designpatterns.behavioral.command.s1.Order;
import com.sauzny.designpatterns.behavioral.command.s2.Stock;

public class BuyStock implements Order {

	private Stock abcStock;

	public BuyStock(Stock abcStock) {
		this.abcStock = abcStock;
	}

	public void execute() {
		abcStock.buy();
	}

}
