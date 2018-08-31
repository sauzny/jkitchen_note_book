package com.sauzny.jkitchen_note.oak.ping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class VultrPing {

	public static void main(String[] args) throws IOException {
		
		List<String> list = Files.readAllLines(Paths.get("E:/info/c.txt"), StandardCharsets.UTF_8);
        
        list.forEach(line->{
            String[] temp = line.split(" - ");
            System.out.print(temp[0] + "\t");
        });
        System.out.println();
        /*
        list.forEach(line->{
            String[] temp = line.split(" - ");
            System.out.print(temp[1] + "\t");
        });
        System.out.println();
        */
        for(int i=0;i<10;i++){
            
            for(String line : list){
                String[] temp = line.split(" - ");
                System.out.print(PingUtils.ping(temp[1]) + "\t");
            }
            System.out.println();
        }
	}

}
