package org.example.lab.jdk11;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection接口新增了一个重载的toArray方法
 */

public class Solution3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // 使用Collection.toArray方法转换为数组
        String[] array = list.toArray(String[]::new);

        // 打印数组元素
        for (String element : array) {
            System.out.println(element);
        }
    }
}
