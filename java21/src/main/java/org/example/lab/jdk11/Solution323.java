package org.example.lab.jdk11;

import java.io.IOException;

/**
 * Lambda 参数的局部变量语法
 */

public class Solution323 {

    public static void main(String[] args) {
        MyInterface myLambda = (var name, var age) -> {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        };

        myLambda.myMethod("John", 25);
    }
}

interface MyInterface {
    void myMethod(String name, int age);
}