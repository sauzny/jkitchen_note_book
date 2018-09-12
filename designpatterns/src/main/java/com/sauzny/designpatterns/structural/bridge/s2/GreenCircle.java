package com.sauzny.designpatterns.structural.bridge.s2;

import com.sauzny.designpatterns.structural.bridge.s1.DrawAPI;

public class GreenCircle implements DrawAPI {
	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
	}
}