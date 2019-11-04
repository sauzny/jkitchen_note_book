package com.sauzny.jkitchen_note.files;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MyFilesAllUpdate {

    public static void update(String targetPath, String splitStr, Map<String, String> map) {
        Path path = Paths.get(targetPath);
        Charset charset = StandardCharsets.UTF_8;

        try {
            // 备份文件
            Path backDirPath = Paths.get("files/update/");
            Path backFilePath = Paths.get("files/update/old.cnf");
            Files.createDirectories(backDirPath);
            Files.copy(path, backFilePath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("备份文件完毕");

            List<String> lines = Files.readAllLines(backFilePath, charset);

            // 准备计算md5值
            StringBuilder oldsb = new StringBuilder();

            // 修改内容
            int i = 0;
            Iterator<String> iterator = lines.iterator();
            while (iterator.hasNext()) {
                String line = iterator.next();
                oldsb.append(line);
                int index = line.indexOf(" ");
                if (index == -1) index = line.indexOf("=");
                if (index != -1) {
                    String key = line.substring(0, index);
                    if (map.containsKey(key)) {
                        lines.set(i, key + splitStr + map.get(key));
                    }
                }
                i++;
            }

            // 输出新的文件
            Path newFilePath = Paths.get("files/update/new.cnf");
            Files.write(newFilePath, lines, StandardOpenOption.CREATE_NEW);
            System.out.println("修改文件完毕");

            // 计算修改前的md5值
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(oldsb.toString().getBytes(StandardCharsets.UTF_8));
            String oldmd5Str = new BigInteger(1, md5.digest()).toString(16);

            // 计算现在的md5值
            md5.update(Files.readAllLines(path, charset).stream().reduce((s1,s2) -> s1+s2).get().getBytes(StandardCharsets.UTF_8));
            String newmd5Str = new BigInteger(1, md5.digest()).toString(16);

            System.out.println(oldmd5Str);
            System.out.println(newmd5Str);

            // 覆盖旧文件
            if(oldmd5Str.equals(newmd5Str)) Files.copy(newFilePath, path, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("覆盖旧文件完毕");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyFilesAllUpdate.update("files/properties.cnf", "=", Map.of("word", "abc"));
    }
}
