package com.sauzny.jkitchen_note.clone;

public class CloneManager {

    /**
                克隆需要注意的是
                
     1.实例中的基本类型和非基本类型
     
                 只是克隆基本类型 叫做 影子克隆
                 克隆了基本和非基本类型 叫做 深度克隆
                 
     2.不是所有的类都能克隆或者深度克隆
                 有些类是final的，同时不重载clone方法
      
     3.String
                 并没有实现深度克隆，
      String是不可变类（immutable class）
      String中函数的调用都会返回一个新的对象
     */
    
    /**
     * @描述: 简单克隆
     * @返回 void
     * @创建人  ljx 创建时间 2017年10月10日 下午4:03:32
     */
    public void simple(){
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
    
    /**
     * @描述: 影子克隆
     * @返回 void
     * @创建人  ljx 创建时间 2017年10月10日 下午4:06:10
     */
    public void shadow(){

        Student2 stu = new Student2();  
        stu.setAge(1);  
        stu.setName("aa");  
        Bag2 b = new Bag2();  
        b.setWidth(10);  
        b.setLogo("Nike");  
        stu.setBag(b);  
        Student2.printStudent(stu);  
        try {  
            Student2 sC = stu.clone();  
            Student2.printStudent(sC);  
            sC.setAge(12);  
            sC.setName("bb");  
            sC.getBag().setWidth(100);//改变书包的属性  
            sC.getBag().setLogo("JNike");  
            Student2.printStudent(stu);  
            Student2.printStudent(sC);  
        } catch (CloneNotSupportedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }
    
    /**
     * @描述: 深度克隆
     * @返回 void
     * @创建人  ljx 创建时间 2017年10月10日 下午4:07:46
     */
    public void deep(){

        Student3 stu = new Student3();  
        stu.setAge(1);  
        stu.setName("aa");  
        Bag3 b = new Bag3();  
        b.setWidth(10);  
        b.setLogo("Nike");  
        stu.setBag(b);  
        Student3.printStudent(stu);  
        try {  
            Student3 sC = stu.clone();  
            Student3.printStudent(sC);  
            sC.setAge(12);  
            sC.setName("bb");  
            sC.getBag().setWidth(100);//改变书包的属性  
            sC.getBag().setLogo("JNike");  
            Student3.printStudent(stu);  
            Student3.printStudent(sC);  
        } catch (CloneNotSupportedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }
}
