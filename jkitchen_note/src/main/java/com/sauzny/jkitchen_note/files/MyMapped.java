package com.sauzny.jkitchen_note.files;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MyMapped {

    public static void rw(){

        Path path = Paths.get("files/properties.cnf");
        Charset charset = StandardCharsets.UTF_8;

        try (FileChannel fc = FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_WRITE, 0, path.toFile().length());

            // 读写文件
            // 关闭资源
            // 映射文件可能需要unmap释放，使用反射执行unmap

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
