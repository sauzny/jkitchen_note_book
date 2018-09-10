package com.sauzny.designpatterns.create.builder.s4;

import com.sauzny.designpatterns.create.builder.s3.ColdDrink;

public class Coke extends ColdDrink {

	@Override
	public float price() {
		return 30.0f;
	}

	@Override
	public String name() {
		return "Coke";
	}
}