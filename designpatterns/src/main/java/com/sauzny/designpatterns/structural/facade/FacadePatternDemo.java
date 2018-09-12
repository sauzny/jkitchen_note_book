package com.sauzny.designpatterns.structural.facade;

import com.sauzny.designpatterns.structural.facade.s3.ShapeMaker;

public class FacadePatternDemo {
	
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();

		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}
}
