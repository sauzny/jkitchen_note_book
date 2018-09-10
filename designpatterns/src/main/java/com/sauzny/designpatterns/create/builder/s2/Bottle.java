package com.sauzny.designpatterns.create.builder.s2;

import com.sauzny.designpatterns.create.builder.s1.Packing;

public class Bottle implements Packing {

	@Override
	public String pack() {
		return "Bottle";
	}
}
