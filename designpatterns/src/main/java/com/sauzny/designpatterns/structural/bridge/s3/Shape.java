package com.sauzny.designpatterns.structural.bridge.s3;

import com.sauzny.designpatterns.structural.bridge.s1.DrawAPI;

public abstract class Shape {
	protected DrawAPI drawAPI;

	protected Shape(DrawAPI drawAPI) {
		this.drawAPI = drawAPI;
	}

	public abstract void draw();
}
