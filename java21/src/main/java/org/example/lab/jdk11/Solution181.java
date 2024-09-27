package org.example.lab.jdk11;

/**
 * 基于嵌套的访问控制
 * **private**的嵌套形式（private nested）：内部类声明为private的嵌套形式时，只有外部类可以访问该嵌套类。
 * **protected**的嵌套形式（protected nested）：内部类声明为protected的嵌套形式时，只有外部类及其子类可以访问该嵌套类。
 */

public class Solution181 {

    private int privateField;

    private static class PrivateNestedClass {
        private void privateMethod() {
            Solution181 outer = new Solution181();
            outer.privateField = 10;
        }
    }

    protected static class ProtectedNestedClass {
        protected void protectedMethod() {
            Solution181 outer = new Solution181();
            outer.privateField = 20;
        }
    }

    public static void main(String[] args) {
        PrivateNestedClass privateNested = new PrivateNestedClass();
        privateNested.privateMethod();

        ProtectedNestedClass protectedNested = new ProtectedNestedClass();
        protectedNested.protectedMethod();
    }

}
