package org.example.lab.jdk14;

public class Solution361 {
    public static void main(String[] args) {
        foo01();
        foo02();
        foo03();
    }

    // 使用箭头语法（Arrow Syntax）：
    private static void foo01(){
        int dayOfWeek = 3;
        String dayType = switch (dayOfWeek) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeek);
        };
    }

    // 使用多个标签（Multiple Labels）：
    private static void foo02(){
        int number = 2;
        switch (number) {
            case 1, 2, 3:
                System.out.println("Number is between 1 and 3");
                break;
            case 4, 5, 6:
                System.out.println("Number is between 4 and 6");
                break;
            default:
                System.out.println("Number is out of range");
                break;
        }
    }

    // 使用yield语句返回值（Yield Statement）：
    private static void foo03(){
        int number = 2;
        String numberType = switch (number) {
            case 0:
            case 1:
                yield "Even";
            case 2:
            case 3:
                yield "Odd";
            default:
                yield "Unknown";
        };
    }

}
