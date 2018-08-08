package com.sauzny.jkitchen_note.oak.clone;

public class Student3 implements Cloneable {  
    private String name;  
    private int age;  
    private Bag3 bag;  
      
    public Bag3 getBag() {  
        return bag;  
    }  
    public void setBag(Bag3 bag) {  
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
    protected Student3 clone() throws CloneNotSupportedException {  
        Student3 stu = (Student3)super.clone();  
        stu.bag = bag.clone();  
        return stu;  
    }  
    
    /** 
     * 输出 
     * @param stu 
     */  
    public static void printStudent(Student3 stu) {  
        System.out.println(stu + " age: " + stu.getAge() + " name: " + stu.getName() +   
                " bag: " + stu.getBag() + "(" + stu.getBag().getLogo() + " width: " +   
                stu.getBag().getWidth() + ")");  
    }  
}
