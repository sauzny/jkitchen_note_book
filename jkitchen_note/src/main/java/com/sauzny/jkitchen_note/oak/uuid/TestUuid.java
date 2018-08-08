package com.sauzny.jkitchen_note.oak.uuid;

import java.util.Set;
import java.util.UUID;

import com.google.common.collect.Sets;

public class TestUuid {

    public static void foo01() {

        Set<String> set = Sets.newHashSet();

        for (int i = 0; i < 1000000; i++) {
            String uuid = UUID.randomUUID().toString();
            set.add(uuid.split("-")[0]);
        }

        System.out.println(set.size());
    }

    public static String[] chars = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};


    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }

    public static void foo02() {

        Set<String> set = Sets.newHashSet();

        for (int i = 0; i < 10000000; i++) {
            set.add(generateShortUuid());
        }

        System.out.println(set.size());
    }

    public static void main(String[] args) {
        foo02();
    }
}
