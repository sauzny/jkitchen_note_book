package com.sauzny.jkitchen_note.exception;

public class ExceptionA {

    public void a() throws Exception{
        try{
            Integer.parseInt("aaa");
        } catch (NumberFormatException e) {
            throw new RuntimeException(new IllegalArgumentException(e));
        }
    }
}
