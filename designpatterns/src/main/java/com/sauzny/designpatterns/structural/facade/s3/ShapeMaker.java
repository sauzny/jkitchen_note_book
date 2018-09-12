package com.sauzny.designpatterns.structural.facade.s3;

import com.sauzny.designpatterns.structural.facade.s1.Shape;
import com.sauzny.designpatterns.structural.facade.s2.Circle;
import com.sauzny.designpatterns.structural.facade.s2.Rectangle;
import com.sauzny.designpatterns.structural.facade.s2.Square;

public class ShapeMaker {
	private Shape circle;
	private Shape rectangle;
	private Shape square;

	public ShapeMaker() {
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}

	public void drawCircle() {
		circle.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}

	public void drawSquare() {
		square.draw();
	}
}
