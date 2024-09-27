package org.example.lab.jdk17;

/**
 * 在Java 17中，我们可以使用sealed关键字来声明一个封闭类，同时使用permits关键字列出该类允许继承的子类。
 * 封闭类的子类可以继续使用sealed来限制子类，
 * 或者使用no-sealed关键字来表示子类不受限制。
 */

public class Solution409 {
    public static void main(String[] args) {

    }
}

// 定义一个受限制的Shape封闭类，该类只允许被Circle和Rectangle继承。
sealed class Shape permits Circle, Rectangle {

}

// 封闭类的子类只允许用final、sealed、non-sealed修饰
final class Circle extends Shape {

}

non-sealed class Rectangle extends Shape {

}

class OtherShape extends Rectangle {

}
