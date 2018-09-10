package com.sauzny.designpatterns.create.factory.s3;

import com.sauzny.designpatterns.create.factory.s1.Shape;
import com.sauzny.designpatterns.create.factory.s2.Circle;
import com.sauzny.designpatterns.create.factory.s2.Rectangle;
import com.sauzny.designpatterns.create.factory.s2.Square;

public class ShapeFactory {

	// 使用 getShape 方法获取形状类型的对象
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
}
