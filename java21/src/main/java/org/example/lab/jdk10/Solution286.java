package org.example.lab.jdk10;

import java.io.IOException;
import java.util.List;

/**
 * Java 11引入了var关键字，可以在局部变量声明时使用，编译器会根据初始化表达式的类型推断变量的类型。
 */

public class Solution286 {

    public static void main(String[] args) throws IOException {
        var name = "Alice";
        var age = 30;
        var list = List.of("Apple", "Banana", "Orange");
        System.out.println(name + " " + age + " " + list.toString());
    }
}
