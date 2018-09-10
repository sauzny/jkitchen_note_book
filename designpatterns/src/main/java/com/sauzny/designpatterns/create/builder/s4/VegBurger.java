package com.sauzny.designpatterns.create.builder.s4;

import com.sauzny.designpatterns.create.builder.s3.Burger;

public class VegBurger extends Burger {
	@Override
	public float price() {
		return 25.0f;
	}

	@Override
	public String name() {
		return "Veg Burger";
	}
}
