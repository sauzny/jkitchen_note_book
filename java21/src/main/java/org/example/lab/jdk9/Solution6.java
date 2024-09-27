package org.example.lab.jdk9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 在Java 9中，可以在try关键字之后声明资源的匿名变量，并在try语句块中使用
 */

public class Solution6 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
