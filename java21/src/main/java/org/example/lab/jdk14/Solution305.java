package org.example.lab.jdk14;

public class Solution305 {
    public static void main(String[] args) {

    }

    public static void processShape(Shape shape) {
        if (shape instanceof Circle c) {
            double area = Math.PI * c.getRadius() * c.getRadius();
            System.out.println("Circle area: " + area);
        } else if (shape instanceof Rectangle r) {
            double area = r.getWidth() * r.getHeight();
            System.out.println("Rectangle area: " + area);
        } else if (shape instanceof Triangle t) {
            double area = 0.5 * t.getBase() * t.getHeight();
            System.out.println("Triangle area: " + area);
        } else {
            System.out.println("Unknown shape");
        }
    }
}

class Shape {

}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }
}