package org.example.lab.jdk14;

public class Solution359 {

    public static void main(String[] args) {
        // 创建记录类型的实例
        Person person = new Person("John Doe", 30);

// 访问记录类型的属性
        String name = person.name();
        int age = person.age();

// 自动生成的toString()方法
        System.out.println(person);

    }
}

record Person(String name, int age) {
    // 自动生成了构造函数和getter方法
}

