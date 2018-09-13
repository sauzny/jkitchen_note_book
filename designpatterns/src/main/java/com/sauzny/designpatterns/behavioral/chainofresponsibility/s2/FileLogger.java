package com.sauzny.designpatterns.behavioral.chainofresponsibility.s2;

import com.sauzny.designpatterns.behavioral.chainofresponsibility.s1.AbstractLogger;

public class FileLogger extends AbstractLogger {

	public FileLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("File::Logger: " + message);
	}
}