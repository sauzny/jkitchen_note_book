package com.sauzny.jkitchen_note.exception;

public class ExceptionC {

    public void c() throws Exception{
        try{
            new ExceptionB().b();
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
