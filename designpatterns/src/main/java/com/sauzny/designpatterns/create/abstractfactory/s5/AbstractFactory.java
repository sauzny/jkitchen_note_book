package com.sauzny.designpatterns.create.abstractfactory.s5;

import com.sauzny.designpatterns.create.abstractfactory.s1.Shape;
import com.sauzny.designpatterns.create.abstractfactory.s3.Color;

public abstract class AbstractFactory {
	
	public abstract Color getColor(String color);

	public abstract Shape getShape(String shape);
}
