package com.sauzny.designpatterns.behavioral.nullobject.s2;

import com.sauzny.designpatterns.behavioral.nullobject.s1.AbstractCustomer;

public class RealCustomer extends AbstractCustomer {

	public RealCustomer(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isNil() {
		return false;
	}

}
