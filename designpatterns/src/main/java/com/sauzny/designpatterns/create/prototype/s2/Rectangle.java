package com.sauzny.designpatterns.create.prototype.s2;

import com.sauzny.designpatterns.create.prototype.s1.Shape;

public class Rectangle extends Shape {

	public Rectangle() {
		type = "Rectangle";
	}

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}

}
