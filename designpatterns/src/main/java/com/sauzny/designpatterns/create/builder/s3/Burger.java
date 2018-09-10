package com.sauzny.designpatterns.create.builder.s3;

import com.sauzny.designpatterns.create.builder.s1.Item;
import com.sauzny.designpatterns.create.builder.s1.Packing;
import com.sauzny.designpatterns.create.builder.s2.Wrapper;

public abstract class Burger implements Item {

	@Override
	public Packing packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();
}
