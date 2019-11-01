package com.sauzny.jkitchen_note.clone;

public class Student implements Cloneable {
    private String name;
    private int age;
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
    protected Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }
    
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setAge(1);
        stu.setName("aa");
        System.out.println(stu + " age: " + stu.getAge() + " name: " + stu.getName());
        try {
            Student sC = stu.clone();
            System.out.println(sC + " sC.age: " + sC.getAge() + " sC.name: " + sC.getName());
            sC.setAge(12);
            sC.setName("bb");
            System.out.println(stu + " age: " + stu.getAge() + " name: " + stu.getName());
            System.out.println(sC + " sC.age: " + sC.getAge() + " sC.name: " + sC.getName());
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

