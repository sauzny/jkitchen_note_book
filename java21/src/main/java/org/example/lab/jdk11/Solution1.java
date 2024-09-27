package org.example.lab.jdk11;

/**
 * String类添加了一些新方法：isBlank、strip、stripLeading、stripTrailing和repeat。
 * 这些方法主要是从多行字符串中提取非空白字符串和去除换行符或空格符的。
 */

public class Solution1 {
    public static void main(String[] args) {

        String str1 = " ";
        System.out.println(str1.isBlank()); // true

        String repeated = "Hello, ".repeat(3);
        System.out.println(repeated); // "Hello, Hello, Hello, "

        String text = "   Trim me   ";
        System.out.println(text.strip()); // "Trim me"
        System.out.println(text.stripLeading()); // "Trim me   "
        System.out.println(text.stripTrailing());// "   Trim me"
    }
}
