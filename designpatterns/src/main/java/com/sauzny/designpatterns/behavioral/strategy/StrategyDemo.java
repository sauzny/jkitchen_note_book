package com.sauzny.designpatterns.behavioral.strategy;

import com.sauzny.designpatterns.behavioral.strategy.s2.OperationAdd;
import com.sauzny.designpatterns.behavioral.strategy.s2.OperationMultiply;
import com.sauzny.designpatterns.behavioral.strategy.s2.OperationSubstract;
import com.sauzny.designpatterns.behavioral.strategy.s3.Context;

public class StrategyDemo {

	public static void main(String[] args) {
		Context context = new Context(new OperationAdd());
		System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

		context = new Context(new OperationSubstract());
		System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

		context = new Context(new OperationMultiply());
		System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	}

}
