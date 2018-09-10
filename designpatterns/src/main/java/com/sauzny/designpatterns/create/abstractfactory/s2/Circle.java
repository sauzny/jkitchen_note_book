package com.sauzny.designpatterns.create.abstractfactory.s2;

import com.sauzny.designpatterns.create.abstractfactory.s1.Shape;

public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}
