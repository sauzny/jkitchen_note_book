package com.sauzny.designpatterns.create.abstractfactory.s6;

import com.sauzny.designpatterns.create.abstractfactory.s1.Shape;
import com.sauzny.designpatterns.create.abstractfactory.s3.Color;
import com.sauzny.designpatterns.create.abstractfactory.s4.Blue;
import com.sauzny.designpatterns.create.abstractfactory.s4.Green;
import com.sauzny.designpatterns.create.abstractfactory.s4.Red;
import com.sauzny.designpatterns.create.abstractfactory.s5.AbstractFactory;

public class ColorFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType) {
		return null;
	}

	@Override
	public Color getColor(String color) {
		if (color == null) {
			return null;
		}
		if (color.equalsIgnoreCase("RED")) {
			return new Red();
		} else if (color.equalsIgnoreCase("GREEN")) {
			return new Green();
		} else if (color.equalsIgnoreCase("BLUE")) {
			return new Blue();
		}
		return null;
	}

}
