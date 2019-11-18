package com.sauzny.jkitchen_note.files;

import com.google.common.collect.Lists;
import com.sauzny.jkitchen_note.Print;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class MyFiles {

    public static void files1(){

        Path path = Paths.get("files/Rockets.txt");
        Charset charset = StandardCharsets.UTF_8;
        try {
            List<String> lines1 = Files.readAllLines(path, charset);
            lines1.forEach(System.out::println);

            // StandardOpenOption的特殊记录
            // DELETE_ON_CLOSE 这个似乎不是很好用
            // Sparse files 稀疏文件 是一个分配了大小但实际上没有填充的文件

            Files.writeString(path, System.getProperty("line.separator")+"1111", charset, StandardOpenOption.APPEND);

            Print.hr("追加内容");

            List<String> lines2 = Files.readAllLines(path, charset);
            lines2.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void files2(){

        Path path = Paths.get("files/zhuanyi.txt");
        Charset charset = StandardCharsets.UTF_8;

        try {
            Files.writeString(path, "aaaa|bbbb|cccc|d\\"+System.getProperty("line.separator")+"dd\\|d"+System.getProperty("line.separator"), charset, StandardOpenOption.TRUNCATE_EXISTING);
            Files.lines(path, charset).forEach(s -> {
                System.out.println(s);
                Stream.of(s.split("\\|")).forEach(System.out::println);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void files3(){

        Path path = Paths.get("E:\\doc\\2019\\11月12月封闭");
        Charset charset = StandardCharsets.UTF_8;

        Lists.newArrayList(path.toFile().list()).forEach(name ->{
            System.out.println(name);
            for(byte b : name.getBytes(charset)){
                System.out.print(" " + b);
            }
            System.out.println();
        });
    }

    public static void main(String[] args) {
        MyFiles.files3();
    }
}
