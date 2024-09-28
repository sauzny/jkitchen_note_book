package org.example.lab.jdk21;

import java.util.*;

/**
 * 序集合的操作接口
 *
 * JDK 21 引入了一种新的集合类型：Sequenced Collections（序列化集合，也叫有序集合），
 * 这是一种具有确定出现顺序（encounter order）的集合（无论我们遍历这样的集合多少次，元素的出现顺序始终是固定的）。
 * 序列化集合提供了处理集合的第一个和最后一个元素以及反向视图（与原始集合相反的顺序）的简单方法。
 *
 * Sequenced Collections 包括以下三个接口：
 * SequencedCollection
 * SequencedSet
 * SequencedMap
 */

public class Solution431 {

    public static void main(String[] args) {




    }

    // List 和 Deque 接口实现了SequencedCollection 接口。
    private static void foo01(){
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);   // List contains: [1]

        arrayList.addFirst(0);  // List contains: [0, 1]
        arrayList.addLast(2);   // List contains: [0, 1, 2]

        Integer firstElement = arrayList.getFirst();  // 0
        Integer lastElement = arrayList.getLast();  // 2

        List<Integer> reversed = arrayList.reversed();
        System.out.println(reversed); // Prints [2, 1, 0]
    }

    // SortedSet 和 LinkedHashSet 实现了SequencedSet接口。
    private static void foo02(){
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(List.of(1, 2, 3));

        Integer firstElement = linkedHashSet.getFirst();   // 1
        Integer lastElement = linkedHashSet.getLast();    // 3

        linkedHashSet.addFirst(0);  //List contains: [0, 1, 2, 3]
        linkedHashSet.addLast(4);   //List contains: [0, 1, 2, 3, 4]

        System.out.println(linkedHashSet.reversed());   //Prints [5, 3, 2, 1, 0]
    }

    // SortedMap 和LinkedHashMap 实现了SequencedMap 接口
    private static void foo03(){
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        map.firstEntry();   //1=One
        map.lastEntry();    //3=Three

        System.out.println(map);  //{1=One, 2=Two, 3=Three}

        Map.Entry<Integer, String> first = map.pollFirstEntry();   //1=One
        Map.Entry<Integer, String> last = map.pollLastEntry();    //3=Three

        System.out.println(map);  //{2=Two}

        map.putFirst(1, "One");     //{1=One, 2=Two}
        map.putLast(3, "Three");    //{1=One, 2=Two, 3=Three}

        System.out.println(map);  //{1=One, 2=Two, 3=Three}
        System.out.println(map.reversed());   //{3=Three, 2=Two, 1=One}
    }
}
