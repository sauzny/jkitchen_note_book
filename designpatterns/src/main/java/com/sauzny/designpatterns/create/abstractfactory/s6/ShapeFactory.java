package com.sauzny.designpatterns.create.abstractfactory.s6;

import com.sauzny.designpatterns.create.abstractfactory.s1.Shape;
import com.sauzny.designpatterns.create.abstractfactory.s2.Circle;
import com.sauzny.designpatterns.create.abstractfactory.s2.Rectangle;
import com.sauzny.designpatterns.create.abstractfactory.s2.Square;
import com.sauzny.designpatterns.create.abstractfactory.s3.Color;
import com.sauzny.designpatterns.create.abstractfactory.s5.AbstractFactory;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}

	@Override
	public Color getColor(String color) {
		return null;
	}

}
