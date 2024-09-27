package org.example.lab.jdk11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Java 11向Files类添加了一些静态方法readString和writeString。让文件的读写更加容易。
 */

public class Solution2 {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        File tempFile = new File(path + File.separator + "temp.txt");
        Files.writeString(tempFile.toPath(),"Hello! Java 11");
        String readStr = Files.readString(tempFile.toPath());
        System.out.println(readStr); // "Hello! Java 11"
    }
}
