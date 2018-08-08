package com.sauzny.jkitchen_note.poi;

import java.util.List;

import org.elasticsearch.common.collect.Lists;

public class MainTest {

    public static void main(String[] args) {
        List<String> names1 = Lists.newArrayList("宝坻", "北辰", "大港", "东丽", "和平", "河北", "河东", "黑牛城道", "红桥", "华苑", "蓟县", "津南", "静海", "开发区", "南开", "宁河", "塘沽", "卫国道", "西北角", "杨柳青");
     
        names1.forEach(name ->{
            System.out.println("select '"+name+"' as city,  `课程`, count(`课程`) FROM `"+name+"` GROUP BY `课程` UNION ALL");
        });
        

        System.out.println("-----------------------------");
        
        List<String> names2 = Lists.newArrayList("大观园", "德州", "洪楼", "淮南", "济宁", "兰州", "乐松", "临沂", "太平桥", "潍坊", "芜湖", "西宁", "香河", "新阳路", "淄博");
     
        names2.forEach(name ->{
            System.out.println("select '"+name+"' as city,  `课程`, count(`课程`) FROM `"+name+"` GROUP BY `课程` UNION ALL");
        });
    }
}
