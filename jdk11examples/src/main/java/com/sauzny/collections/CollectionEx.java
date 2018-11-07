package com.sauzny.collections;

import java.util.*;

public class CollectionEx {

    public static void main(String[] args) {

        // 转换成数组的新函数
        List<String> foo01 = List.of("jdk10", "jdk11");
        String[] foo02 = foo01.toArray(String[]::new);

        System.out.println(foo02.length);

        // 泛型里可以不写 实际的类型，但是大家都用guava吧
        var foo03 = new ArrayList<>();

        // 这些of函数都是不可变集合

        // 空列表，数据类型为 Object
        List emptyImmutableList = List.of();

        // 创建 List<String>
        var list = List.of("jdk7", "jdk8", "jdk9");

        // 创建一个空 Set<String>
        Set<String> immutableSet = Set.of();

        // 快速创建一个 Set<String>
        var bar = Set.of("jdk7", "jdk8", "jdk9", "jdk10");

        // 空 Map，Key 和 Value 类型都是 Object
        Map emptyImmutableMap = Map.of();

        // 快速创建一个 Map
        var map = Map.of(10, "jdk10", 11, "jdk11");

        // 使用 Entries 创建一个 Map
        Map<Integer, String> emptyEntryMap = Map.ofEntries(
                Map.entry(7, "jdk7"),
                Map.entry(8, "jdk8"),
                Map.entry(9, "jdk9")
        );

        // 创建一个 Map.Entry
        Map.Entry<String, String> immutableMapEntry = Map.entry("key", "value");
        // 其实和上面的代码片段是一样一样的
        Map.ofEntries(immutableMapEntry);

        System.out.println();
    }
}
