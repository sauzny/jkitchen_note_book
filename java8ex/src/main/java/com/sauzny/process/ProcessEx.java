package com.sauzny.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ProcessEx {

    public static void dfh(){

        Charset charset = StandardCharsets.UTF_8;

        ProcessBuilder pb = new ProcessBuilder();
        // shell 命令需要这样分开执行
        pb.command("ssh", "root@172.16.8.211", "df", "-h");
        try {
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8));
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProcessEx.dfh();
    }
}
