package com.sauzny.designpatterns.behavioral.nullobject.s3;

import com.sauzny.designpatterns.behavioral.nullobject.s1.AbstractCustomer;
import com.sauzny.designpatterns.behavioral.nullobject.s2.NullCustomer;
import com.sauzny.designpatterns.behavioral.nullobject.s2.RealCustomer;

public class CustomerFactory {

	public static final String[] names = { "Rob", "Joe", "Julie" };

	public static AbstractCustomer getCustomer(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equalsIgnoreCase(name)) {
				return new RealCustomer(name);
			}
		}
		return new NullCustomer();
	}
}
