package com.sauzny.designpatterns.create.prototype.s2;

import com.sauzny.designpatterns.create.prototype.s1.Shape;

public class Square extends Shape {

	public Square() {
		type = "Square";
	}

	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}

}
