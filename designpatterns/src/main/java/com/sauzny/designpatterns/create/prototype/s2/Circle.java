package com.sauzny.designpatterns.create.prototype.s2;

import com.sauzny.designpatterns.create.prototype.s1.Shape;

public class Circle extends Shape {

	public Circle() {
		type = "Circle";
	}

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}

}
