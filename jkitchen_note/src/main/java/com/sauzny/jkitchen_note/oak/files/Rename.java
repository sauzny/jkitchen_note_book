package com.sauzny.jkitchen_note.oak.files;

import java.io.File;

public class Rename {

    public static void renameDir(File dir){
        File[] files = dir.listFiles();
        for(int i=0;i<files.length;i++){
            String path = files[i].getPath();
            if(path.endsWith("in")){
                files[i].renameTo(new File(path.substring(0, path.length()-3)));
            }
        }
    }
    
    public static void main(String[] args) {
        //File file = new File("C:\\Users\\1\\Downloads\\wrapper-windows-x86-64-3.5.35-pro\\agent\\bin\\App.bat.in");
        //file.renameTo(new File("C:\\Users\\1\\Downloads\\wrapper-windows-x86-64-3.5.35-pro\\agent\\bin\\App.bat"));
        
        Rename.renameDir(new File("C:\\Users\\1\\Downloads\\wrapper-windows-x86-64-3.5.35-pro\\agent\\bin"));
    }
}
