package org.example.lab.jdk21;

/**
 * record模式
 */

public class Solution440 {

    // TODO

    public static void main(String[] args) {
        Person person = new Person("Bob",21);
        if(person instanceof Person(String name,Integer age)){
            System.out.println(name + " " + age);
        }
    }
}

record Person(String name,Integer age){};