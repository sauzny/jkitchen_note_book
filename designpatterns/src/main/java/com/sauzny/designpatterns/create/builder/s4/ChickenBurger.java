package com.sauzny.designpatterns.create.builder.s4;

import com.sauzny.designpatterns.create.builder.s3.Burger;

public class ChickenBurger extends Burger {

	@Override
	public float price() {
		return 50.5f;
	}

	@Override
	public String name() {
		return "Chicken Burger";
	}
}