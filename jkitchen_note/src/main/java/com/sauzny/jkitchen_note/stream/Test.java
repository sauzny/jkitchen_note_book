package com.sauzny.jkitchen_note.stream;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;


public class Test {

    public static void main(String[] args) {

        Lists.newArrayList(4, 5, 6, 8).stream().forEach(i -> {
            System.out.println(i);
        });
        
        List<String> list = Lists.newArrayList("1","2","3");

        // 并行处理
        list.parallelStream();
        
        // map转换数据类型
        List<Integer> list1 = list.stream().map(value -> Integer.parseInt(value)).collect(Collectors.toList());
        
        // mapToInt转换数据类型  需要boxed
        List<Integer> list2 = list.stream().mapToInt(value -> Integer.parseInt(value)).boxed().collect(Collectors.toList());

        
        // mapToInt 也有api在转换为int之后直接获取 和、最大值、最小值等
        IntSummaryStatistics stats = list.stream().mapToInt(value -> Integer.parseInt(value)).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
        
        // map + reduce，求和
        list.stream().map(value -> Integer.parseInt(value)).reduce((sum, item) -> sum + item).get();
        list.stream().map(value -> Integer.parseInt(value)).reduce(Integer::sum).get();
        
        // list 转 map
        Student s1 = new Student(1, "alice");
        Student s2 = new Student(2, "bob");
        Student s3 = new Student(3, "clice");
        
        List<Student> studentList = Lists.newArrayList(s1,s2,s3);
        
        // 
        Map<Integer, String> map = studentList.stream().collect(Collectors.toMap(Student::getId, Student::getName));
        
        list.stream().map(value -> new Student()).collect(Collectors.toList());
        
        //
        System.out.println("======================================================");
        List<Number> numberList = Lists.newArrayList(1L, 3L, 45L);
        
        for(Number number : numberList){
            System.out.println(number.getClass().getSimpleName());
        }
        
        BigDecimal sum = numberList.stream().map(value -> new BigDecimal(value.toString())).reduce(BigDecimal::add).get();
        BigDecimal min = numberList.stream().map(value -> new BigDecimal(value.toString())).reduce(BigDecimal::min).get();
        BigDecimal max = numberList.stream().map(value -> new BigDecimal(value.toString())).reduce(BigDecimal::max).get();
        BigDecimal avg = sum.divide(new BigDecimal(numberList.size()), 2, RoundingMode.HALF_EVEN);
        
        System.out.println(sum);
        System.out.println(min);
        System.out.println(max);
        System.out.println(avg);
        
        try {
            Object obj = numberList.get(0).getClass().getConstructor(String.class).newInstance(sum.toString());
            System.out.println(obj.getClass().getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}

class Student {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Student() {
        super();
    }
   
}