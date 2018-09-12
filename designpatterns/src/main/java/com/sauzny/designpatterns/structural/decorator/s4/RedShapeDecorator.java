package com.sauzny.designpatterns.structural.decorator.s4;

import com.sauzny.designpatterns.structural.decorator.s1.Shape;
import com.sauzny.designpatterns.structural.decorator.s3.ShapeDecorator;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public void draw() {
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}

	private void setRedBorder(Shape decoratedShape) {
		System.out.println("Border Color: Red");
	}
}
