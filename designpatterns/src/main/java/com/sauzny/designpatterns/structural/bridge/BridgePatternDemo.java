package com.sauzny.designpatterns.structural.bridge;

import com.sauzny.designpatterns.structural.bridge.s2.GreenCircle;
import com.sauzny.designpatterns.structural.bridge.s2.RedCircle;
import com.sauzny.designpatterns.structural.bridge.s3.Shape;
import com.sauzny.designpatterns.structural.bridge.s4.Circle;

public class BridgePatternDemo {
	public static void main(String[] args) {
		
		Shape redCircle = new Circle(100, 100, 10, new RedCircle());
		Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

		redCircle.draw();
		greenCircle.draw();
	}
}
