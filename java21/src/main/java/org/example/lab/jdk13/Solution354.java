package org.example.lab.jdk13;

public class Solution354 {

    public static void main(String[] args) {
        foo01();
        foo02();
        foo03();
    }

    // 简单的Switch表达式
    private static void foo01(){
        int day = 3;
        String dayName = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            default -> "Invalid day";
        };

        System.out.println(dayName);  // 输出: Wednesday

    }


    // 表达式和语句的组合：
    private static void foo02(){
        int day = 5;
        String dayType = switch (day) {
            case 1, 2, 3, 4, 5 -> {
                yield "Weekday";  // 使用yield返回一个值
            }
            case 6, 7 -> {
                System.out.println("It's a weekend!");  // 执行语句
                yield "Weekend";
            }
            default -> {
                yield "Invalid day";
            }
        };

        System.out.println(dayType);  // 输出: Weekend
    }


    // 表达式的返回类型推断：
    private static void foo03(){
        String dayName = switch (getDayOfWeek()) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            default -> "Invalid day";
        };

        System.out.println(dayName);
    }

    private static int getDayOfWeek() {
        return 3;
    }
}
