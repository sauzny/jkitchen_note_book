package com.sauzny.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesEx {

    public static void main(String[] args) throws IOException {

        // Files 读写增加了 xxxString 的函数

        var lines = Files.readAllLines(Path.of("E:\\info\\temp\\002.txt"), StandardCharsets.UTF_8);
        lines.forEach(line -> {
            /*
            if(line.contains("waiting on condition")){
                System.out.println(line);
            }
            */
            /*
            if(line.startsWith("\t- parking to wait for")){
                System.out.println(line);
            }
            */
            if(line.contains("qtp")){System.out.println(line);
            }
        });

    }
}
