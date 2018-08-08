package com.sauzny.jkitchen_note.oak.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class ReadRedisBenchmarkLog {

    @Test
    public void read() throws IOException{
        List<String> lines = Files.readAllLines(Paths.get("D:\\Redis-x64-3.2.100\\benchmark02.log"));
        for(String line : lines){
            if(line.contains("======")){
                System.out.print(line.replaceAll("======", ""));
            }
            if(line.contains("per second")){
                System.out.println(line);
            }
        }
    }
}
