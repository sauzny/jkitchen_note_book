package org.example.lab.jdk9;

import java.util.Optional;

/**
 在Java 9中，改进的 Optional 类
 新增了ifPresentOrElse()方法
 增了stream()方法
 or()方法的重载
 ifPresentOrElse()方法的重载
 */

public class Solution8 {
    public static void main(String[] args) {
        Optional<String> optionalValue = Optional.of("Hello");

        // 使用ifPresentOrElse()方法执行操作
        optionalValue.ifPresentOrElse(
                value -> System.out.println("Value: " + value),
                () -> System.out.println("No value present")
        );

        // 使用stream()方法将Optional转换为Stream
        optionalValue.stream()
                .forEach(value -> System.out.println("Stream value: " + value));

        // 使用or()方法提供备选值
        Optional<String> emptyOptional = Optional.empty();
        String result = emptyOptional.or(() -> Optional.of("Default Value"))
                .orElse("Fallback Value");
        System.out.println("Result: " + result);
    }
}
