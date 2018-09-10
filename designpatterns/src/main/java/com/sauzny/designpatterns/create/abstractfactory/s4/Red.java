package com.sauzny.designpatterns.create.abstractfactory.s4;

import com.sauzny.designpatterns.create.abstractfactory.s3.Color;

public class Red implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}
}
