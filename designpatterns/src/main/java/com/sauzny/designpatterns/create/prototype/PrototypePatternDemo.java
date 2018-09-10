package com.sauzny.designpatterns.create.prototype;

import com.sauzny.designpatterns.create.prototype.s1.Shape;
import com.sauzny.designpatterns.create.prototype.s3.ShapeCache;

public class PrototypePatternDemo {
	
	public static void main(String[] args) {
		
		ShapeCache.loadCache();

		Shape clonedShape = (Shape) ShapeCache.getShape("1");
		System.out.println("Shape : " + clonedShape.getType());

		Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
		System.out.println("Shape : " + clonedShape2.getType());

		Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
		System.out.println("Shape : " + clonedShape3.getType());
	}
}
