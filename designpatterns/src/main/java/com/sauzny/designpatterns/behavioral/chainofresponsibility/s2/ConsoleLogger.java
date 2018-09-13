package com.sauzny.designpatterns.behavioral.chainofresponsibility.s2;

import com.sauzny.designpatterns.behavioral.chainofresponsibility.s1.AbstractLogger;

public class ConsoleLogger extends AbstractLogger {

	public ConsoleLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Standard Console::Logger: " + message);
	}

}
