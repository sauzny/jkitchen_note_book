package com.sauzny.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {

        Stream.of("a","b","c","","e","f").takeWhile(s->!s.isEmpty())
                .forEach(System.out::print);

        // 以上实例 takeWhile 方法在碰到空字符串时停止循环输出，执行输出结果为：abc


        Stream.of("a","b","c","","e","f").dropWhile(s-> !s.isEmpty())
                .forEach(System.out::print);

        // 以上实例 dropWhile 方法在碰到空字符串时开始循环输出，执行输出结果为：ef


        IntStream.iterate(3, x -> x < 10, x -> x+ 3).forEach(System.out::println);

        /*
        执行输出结果为：
        3
        6
        9
         */

        long count = Stream.ofNullable(100).count();
        System.out.println(count);

        count = Stream.ofNullable(null).count();
        System.out.println(count);
        /*
        执行输出结果为：
           1
           0
         */
    }
}
