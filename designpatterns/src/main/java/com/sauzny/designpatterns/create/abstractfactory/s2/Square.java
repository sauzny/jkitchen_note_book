package com.sauzny.designpatterns.create.abstractfactory.s2;

import com.sauzny.designpatterns.create.abstractfactory.s1.Shape;

public class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}
