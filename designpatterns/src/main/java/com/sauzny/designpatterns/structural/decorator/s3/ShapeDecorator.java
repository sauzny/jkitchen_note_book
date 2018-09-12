package com.sauzny.designpatterns.structural.decorator.s3;

import com.sauzny.designpatterns.structural.decorator.s1.Shape;

public class ShapeDecorator implements Shape {
	
	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	public void draw() {
		decoratedShape.draw();
	}
}