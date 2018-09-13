package com.sauzny.designpatterns.behavioral.strategy.s3;

import com.sauzny.designpatterns.behavioral.strategy.s1.Strategy;

public class Context {

	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public int executeStrategy(int num1, int num2) {
		return strategy.doOperation(num1, num2);
	}
}
