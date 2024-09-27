package org.example.lab.jdk15;

public class Solution360 {

    public static void main(String[] args) {

    }
}

// 防止不受控制的扩展和继承
sealed class Shape permits Circle, Square, Triangle {
    // Class body
}

final class Circle extends Shape {

}

final class Square extends Shape {

}

final class Triangle extends Shape {

}