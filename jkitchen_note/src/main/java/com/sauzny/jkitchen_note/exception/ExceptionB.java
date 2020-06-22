package com.sauzny.jkitchen_note.exception;

public class ExceptionB {

    public void b() throws Exception{
        try{
            new ExceptionA().a();
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
