package org.example.lab.jdk14;

import java.text.NumberFormat;

public class Solution1 {

    public static void main(String[] args) {
        // 与 预期不相符
        /*
        foo01();
        foo02();
        foo03();
        */
    }

    private static void foo01(){
        double value = 12345678;
        NumberFormat nf = NumberFormat.getCompactNumberInstance();
        String formattedValue = nf.format(value);
        System.out.println(formattedValue); // 输出：12M
    }

    private static void foo02(){
        /*
        NumberFormat nf = NumberFormat.getInstance();
        String localizedPattern = nf.toLocalizedPattern();
        String pattern = nf.toPattern();
        System.out.println(localizedPattern);
        System.out.println(pattern);
        */
    }

    private static void foo03(){
        double value = 1234.56789;
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(-1); // 保留尽可能多的小数位数
        nf.setMinimumFractionDigits(2); // 至少保留2位小数
        String formattedValue = nf.format(value);
        System.out.println(formattedValue); // 输出：1,234.56789
    }
}
