package com.sauzny.designpatterns.create.builder.s3;

import com.sauzny.designpatterns.create.builder.s1.Item;
import com.sauzny.designpatterns.create.builder.s1.Packing;
import com.sauzny.designpatterns.create.builder.s2.Bottle;

public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();
}
