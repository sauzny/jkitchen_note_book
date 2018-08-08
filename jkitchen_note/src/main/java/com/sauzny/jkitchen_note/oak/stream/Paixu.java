package com.sauzny.jkitchen_note.oak.stream;

import java.util.List;

import org.elasticsearch.common.collect.Lists;

import lombok.Data;

public class Paixu {

    public static void main(String[] args) {
        
        StudentPaixu s1 = new StudentPaixu(2, "aa");
        StudentPaixu s2 = new StudentPaixu(7, "bb");
        StudentPaixu s3 = new StudentPaixu(1, "cc");
        StudentPaixu s4 = new StudentPaixu(4, "dd");
        StudentPaixu s5 = new StudentPaixu(9, "ee");
        
        List<StudentPaixu> list = Lists.newArrayList(s1, s2, s3, s4, s5);
        
        System.out.println(list);
        
        // 按照id升序排列
        list.sort((StudentPaixu p1, StudentPaixu p2) -> p1.getId() - p2.getId() );
        
        System.out.println(list);
        
        // 按照id降序排列
        list.sort((StudentPaixu p1, StudentPaixu p2) -> p2.getId() - p1.getId() );
        
        System.out.println(list);
        
        // 按照name升序排列
        list.sort((StudentPaixu p1, StudentPaixu p2) -> p1.getName().compareTo(p2.getName()) );
        
        System.out.println(list);
        
        // 按照name降序排列
        list.sort((StudentPaixu p1, StudentPaixu p2) -> p2.getName().compareTo(p1.getName()) );
        
        System.out.println(list);
    }
}

@Data
class StudentPaixu {

    private Integer id;
    private String name;
    
    public StudentPaixu(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public StudentPaixu() {
        super();
    }
   
}