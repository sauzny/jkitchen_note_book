package com.sauzny.jkitchen_note.files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyRandomAccessFile {

    /**
     * 指定修改文件的多处内容
     * 尝试读写文件
     * 靠定位指定需要修改的位置
     * 多次修改会比较麻烦，每次修改后，文件内部结构变化，位置变化
     */
    public static void rw(){
        Path path = Paths.get("files/properties.cnf");
        Charset charset = StandardCharsets.UTF_8;

        try(RandomAccessFile raf = new RandomAccessFile(path.toFile(),"rw");){
            String line = "";
            while(line != null){
                long start = raf.getFilePointer();
                line = raf.readLine();
                long end = raf.getFilePointer();
                if(line != null){
                    System.out.println(String.format("%s~%s - %s", start, end, line));
                }
            }
            System.out.println(raf.length());
            String str = "port=5259";
            raf.seek(7);
            raf.write(str.getBytes(charset));

            System.out.println(raf.readLine());
            System.out.println(raf.readLine());

            raf.seek(0);
            line = "";

            while(line != null){
                long start = raf.getFilePointer();
                line = raf.readLine();
                long end = raf.getFilePointer();
                if(line != null){
                    System.out.println(String.format("%s~%s - %s", start, end, line));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteLastOne(){
        Path path = Paths.get("files/properties.cnf");
        Charset charset = StandardCharsets.UTF_8;

        try(RandomAccessFile raf = new RandomAccessFile(path.toFile(),"rw");){
            raf.seek(path.toFile().length() - 1);
            raf.write(new byte[0]);
            //byte[] bytes = new byte[1024];
            //raf.read(bytes);
            //System.out.println(new String(bytes, charset));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MyRandomAccessFile.deleteLastOne();
    }
}
