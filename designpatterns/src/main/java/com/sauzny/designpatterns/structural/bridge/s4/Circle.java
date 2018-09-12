package com.sauzny.designpatterns.structural.bridge.s4;

import com.sauzny.designpatterns.structural.bridge.s1.DrawAPI;
import com.sauzny.designpatterns.structural.bridge.s3.Shape;

public class Circle extends Shape {
	
	private int x, y, radius;

	public Circle(int x, int y, int radius, DrawAPI drawAPI) {
		super(drawAPI);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public void draw() {
		drawAPI.drawCircle(radius, x, y);
	}
}