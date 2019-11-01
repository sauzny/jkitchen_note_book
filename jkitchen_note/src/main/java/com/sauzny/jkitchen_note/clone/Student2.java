package com.sauzny.jkitchen_note.clone;

public class Student2 implements Cloneable {  
    private String name;  
    private int age;  
    private Bag2 bag;  
      
    public Bag2 getBag() {  
        return bag;  
    }  
    public void setBag(Bag2 bag) {  
        this.bag = bag;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
      
    @Override  
    protected Student2 clone() throws CloneNotSupportedException {  
        return (Student2)super.clone();  
    }  
    
    /** 
     * 输出 
     * @param stu 
     */  
    public static void printStudent(Student2 stu) {  
        System.out.println(stu + " age: " + stu.getAge() + " name: " + stu.getName() +   
                " bag: " + stu.getBag() + "(" + stu.getBag().getLogo() + " width: " +   
                stu.getBag().getWidth() + ")");  
    }  
}