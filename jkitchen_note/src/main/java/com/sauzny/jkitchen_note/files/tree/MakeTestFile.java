package com.sauzny.jkitchen_note.files.tree;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

public class MakeTestFile {

    public static void files1(){

        Path path = Paths.get("files/tree/baseTree.txt");
        Charset charset = StandardCharsets.UTF_8;
        try {
            List<String> lines1 = Files.readAllLines(path, charset);
            lines1.forEach(line -> {
                for(int i=0; i<5; i++){
                    String leaf = UUID.randomUUID().toString().replaceAll("-","") + ".leaf";
                    System.out.println(line+"-"+leaf);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MakeTestFile.files1();
    }

}
