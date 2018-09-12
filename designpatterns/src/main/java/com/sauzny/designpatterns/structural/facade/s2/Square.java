package com.sauzny.designpatterns.structural.facade.s2;

import com.sauzny.designpatterns.structural.facade.s1.Shape;

public class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Square::draw()");
	}
}
