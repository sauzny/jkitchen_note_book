package com.sauzny.designpatterns.behavioral.strategy.s2;

import com.sauzny.designpatterns.behavioral.strategy.s1.Strategy;

public class OperationMultiply implements Strategy {
	@Override
	public int doOperation(int num1, int num2) {
		return num1 * num2;
	}
}
