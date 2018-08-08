package com.sauzny.jkitchen_note.oak.trycatchfinally;

public class MyException1 extends Exception {

    public MyException1(String message) {
        super(message);
    }
    
    public MyException1(String message, Throwable cause) {
        super(message, cause);
    }

}
