package com.sauzny.designpatterns.behavioral.chainofresponsibility.s2;

import com.sauzny.designpatterns.behavioral.chainofresponsibility.s1.AbstractLogger;

public class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Error Console::Logger: " + message);
	}
}
