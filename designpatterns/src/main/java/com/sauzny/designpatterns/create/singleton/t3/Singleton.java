package com.sauzny.designpatterns.create.singleton.t3;

public class Singleton {
	
	private static Singleton instance = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return instance;
	}
}
