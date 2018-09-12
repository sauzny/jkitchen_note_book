package com.sauzny.designpatterns.structural.facade.s2;

import com.sauzny.designpatterns.structural.facade.s1.Shape;

public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Circle::draw()");
	}
}