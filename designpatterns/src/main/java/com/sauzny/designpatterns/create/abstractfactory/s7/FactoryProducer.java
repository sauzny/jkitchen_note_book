package com.sauzny.designpatterns.create.abstractfactory.s7;

import com.sauzny.designpatterns.create.abstractfactory.s5.AbstractFactory;
import com.sauzny.designpatterns.create.abstractfactory.s6.ColorFactory;
import com.sauzny.designpatterns.create.abstractfactory.s6.ShapeFactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("SHAPE")) {
			return new ShapeFactory();
		} else if (choice.equalsIgnoreCase("COLOR")) {
			return new ColorFactory();
		}
		return null;
	}
}
