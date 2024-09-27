package org.example.lab.jdk12;

public class Solution325 {

    public static void main(String[] args) {
        int day = 3;
        String dayName = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid day";
        };
    }
}
