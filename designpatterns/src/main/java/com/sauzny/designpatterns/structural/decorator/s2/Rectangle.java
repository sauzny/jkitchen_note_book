package com.sauzny.designpatterns.structural.decorator.s2;

import com.sauzny.designpatterns.structural.decorator.s1.Shape;

public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Shape: Rectangle");
	}
}