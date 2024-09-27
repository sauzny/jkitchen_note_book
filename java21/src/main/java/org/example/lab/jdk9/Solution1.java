package org.example.lab.jdk9;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 集合框架引入了一组新的工厂方法
 */

public class Solution1 {
    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Orange");
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5);
        Map<String, Integer> studentScores = Map.of("Alice", 95, "Bob", 80, "Charlie", 90);
    }
}
