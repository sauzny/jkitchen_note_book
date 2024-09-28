package org.example.lab.jdk21;

/**
 * switch模式匹配
 */

public class Solution441 {

    public static void main(String[] args) {
        formatterPatternSwitch(1);
    }

    public static String formatterPatternSwitch(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("int %d", i);
            case Long l    -> String.format("long %d", l);
            case Double d  -> String.format("double %f", d);
            case String s  -> String.format("String %s", s);
            default        -> obj.toString();
        };
    }

}

