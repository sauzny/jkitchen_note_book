package com.sauzny.jkitchen_note.Annotation;

public class User {

    private int num;
    private String name;
    
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "User [num=" + num + ", name=" + name + "]";
    }
    
    
}
