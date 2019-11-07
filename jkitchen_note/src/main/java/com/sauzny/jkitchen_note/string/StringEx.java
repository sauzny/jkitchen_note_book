package com.sauzny.jkitchen_note.string;

public class StringEx {

    public static void printSplitLine(){
        System.out.println("=".repeat(30)+"我是分割线"+"=".repeat(30));
    }

    public static void main(String[] args) {

        final String lineSeparator = System.getProperty("line.separator");

        String repeatStr = "+";
        String newrepeatStr = repeatStr.repeat(4);

        System.out.println(String.format(("测试方法 repeatStr.repeat(4)，原字符串 %s，新字符串 %s"), repeatStr, newrepeatStr));

        StringEx.printSplitLine();

        String str = "青光闪动，一柄青钢剑倏地刺出，指向在年汉子左肩，使剑少年不等招用老，腕抖剑斜，剑锋已削向那汉子右颈。" + lineSeparator +
                "那中年汉子剑挡格，铮的一声响，双剑相击，嗡嗡作声，震声未绝，双剑剑光霍霍，已拆了三招，中年汉子长剑猛地击落，直砍少年顶门。" + lineSeparator +
                "那少年避向右侧，左手剑诀一引，青钢剑疾刺那汉子大腿。";

        System.out.println(String.format(("测试方法 str.lines()")));

        str.lines().forEach(System.out::println);

        StringEx.printSplitLine();

        String stripStr = "      练武厅东坐着二人 上首是个四十左右的中年道姑 铁青着脸 嘴唇紧闭   ";

        System.out.println(String.format(("|%s|"), stripStr));
        System.out.println(String.format(("strip {去掉前后空格}\tstripLeading {去掉前空格}\t\tstripTrailing {去掉后空格}")));
        System.out.println(String.format(("|%s|"), stripStr.strip()));
        System.out.println(String.format(("|%s|"), stripStr.stripLeading()));
        System.out.println(String.format(("|%s|"), stripStr.stripTrailing()));
        System.out.println(String.format(("strip和trim的区别，自行观看吧 https://codeday.me/bug/20180925/266496.html")));
        System.out.println(String.format(("|%s|"), stripStr.trim()));
        StringEx.printSplitLine();

        String kong = "     ";
        System.out.println(String.format(("原值|%s|"), kong));
        System.out.println(String.format(("isEmpty() %s"), kong.isEmpty()));
        System.out.println(String.format(("isBlank() %s"), kong.isBlank()));
    }
}
