package com.sauzny.string;

import lombok.extern.slf4j.Slf4j;

import javax.sound.sampled.Line;
import java.util.stream.Stream;

@Slf4j
public class StringEx {

    public static void printSplitLine(){
        System.out.println("=".repeat(30)+"我是分割线"+"=".repeat(30));
    }

    public static void main(String[] args) {

        final String lineSeparator = System.getProperty("line.separator");

        String repeatStr = "+";
        String newrepeatStr = repeatStr.repeat(4);

        log.info("测试方法 repeatStr.repeat(4)，原字符串 {}，新字符串 {}", repeatStr, newrepeatStr);

        StringEx.printSplitLine();

        String str = "青光闪动，一柄青钢剑倏地刺出，指向在年汉子左肩，使剑少年不等招用老，腕抖剑斜，剑锋已削向那汉子右颈。" + lineSeparator +
                "那中年汉子剑挡格，铮的一声响，双剑相击，嗡嗡作声，震声未绝，双剑剑光霍霍，已拆了三招，中年汉子长剑猛地击落，直砍少年顶门。" + lineSeparator +
                "那少年避向右侧，左手剑诀一引，青钢剑疾刺那汉子大腿。";

        log.info("测试方法 str.lines()");

        str.lines().forEach(s -> {
            System.out.println(s);
        });

        StringEx.printSplitLine();

        String stripStr = "      练武厅东坐着二人 上首是个四十左右的中年道姑 铁青着脸 嘴唇紧闭   ";

        log.info("|{}|", stripStr);
        log.info("strip {去掉前后空格}\tstripLeading {去掉前空格}\t\tstripTrailing {去掉后空格}");
        log.info("|{}|", stripStr.strip());
        log.info("|{}|", stripStr.stripLeading());
        log.info("|{}|", stripStr.stripTrailing());
        log.info("strip和trim的区别，自行观看吧 https://codeday.me/bug/20180925/266496.html");
        log.info("|{}|", stripStr.trim());
        StringEx.printSplitLine();

        String kong = "     ";
        log.info("原值|{}|", kong);
        log.info("isEmpty() {}", kong.isEmpty());
        log.info("isBlank() {}", kong.isBlank());
    }
}
