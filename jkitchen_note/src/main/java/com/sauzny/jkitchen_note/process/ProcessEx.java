package com.sauzny.jkitchen_note.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.ZoneId;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessEx {

    public static void notepad(){

        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        String np = "Not Present";
        try {
            Process p = pb.start();
            ProcessHandle.Info info = p.info();
            System.out.printf("Process ID : %s%n", p.pid());
            System.out.printf("Command name : %s%n", info.command().orElse(np));
            System.out.printf("Command line : %s%n", info.commandLine().orElse(np));

            System.out.printf("Start time: %s%n",
                    info.startInstant().map(i -> i.atZone(ZoneId.systemDefault())
                            .toLocalDateTime().toString()).orElse(np));

            System.out.printf("Arguments : %s%n",
                    info.arguments().map(a -> Stream.of(a).collect(
                            Collectors.joining(" "))).orElse(np));

            System.out.printf("User : %s%n", info.user().orElse(np));

            ProcessHandle ph =  ProcessHandle.current();
            long pid =  ph.pid();
            System.out.println("PID："+pid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ls(){

        Charset charset = StandardCharsets.UTF_8;

        ProcessBuilder pb = new ProcessBuilder();
        pb.command("cmd", "/C",
                "dir");
        try {
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dfh(){

        Charset charset = StandardCharsets.UTF_8;

        ProcessBuilder pb = new ProcessBuilder();
        pb.command("ssh root@172.16.8.211 \"df -h\"");
        try {
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProcessEx.dfh();
    }
}
