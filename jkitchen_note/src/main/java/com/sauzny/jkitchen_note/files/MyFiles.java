package com.sauzny.jkitchen_note.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/***************************************************************************
 *
 * @时间: 2019/5/10 - 13:53
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class MyFiles {

    public static void main(String[] args) {
        try {
            for (int i = 2; i < 13; i++) {
                Files.copy(
                        Paths.get("E:\\temp\\mgepm_upload", "test1" + ".doc"),
                        Paths.get("E:\\temp\\mgepm_upload", "test"+i + ".doc")
                );

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
