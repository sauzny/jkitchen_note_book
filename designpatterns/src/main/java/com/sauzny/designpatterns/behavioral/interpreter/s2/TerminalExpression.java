package com.sauzny.designpatterns.behavioral.interpreter.s2;

import com.sauzny.designpatterns.behavioral.interpreter.s1.Expression;

public class TerminalExpression implements Expression {

	private String data;

	public TerminalExpression(String data) {
		this.data = data;
	}

	@Override
	public boolean interpret(String context) {
		if (context.contains(data)) {
			return true;
		}
		return false;
	}
}
