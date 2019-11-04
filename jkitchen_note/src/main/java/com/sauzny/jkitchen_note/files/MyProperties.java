package com.sauzny.jkitchen_note.files;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class MyProperties {

    public static void read(){
        Path path = Paths.get("files/properties.cnf");
        Charset charset = StandardCharsets.UTF_8;

        // 继承map
        // 无序
        Properties p = new Properties();

        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()), charset));
            p.load(bf);
            p.entrySet().forEach(objectObjectEntry -> {
                System.out.println(String.format("%s - %s", objectObjectEntry.getKey(), objectObjectEntry.getValue()));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(){
        Path path = Paths.get("files/properties.cnf");
        Charset charset = StandardCharsets.UTF_8;

        Properties p = new Properties();

        try {

            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()), charset));
            p.load(bf);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path.toString()), charset));
            p.setProperty("word", "hello");
            String comments = "";
            p.store(bw, comments);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyProperties.write();
    }
}
