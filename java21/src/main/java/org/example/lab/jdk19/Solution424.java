package org.example.lab.jdk19;

import jdk.jfr.MemoryAddress;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.util.Arrays;


/*
外部函数和内存 API 在 Java 17 中进行了第一轮孵化，由 JEP 412 提出。
第二轮孵化由JEP 419 提出并集成到了 Java 18 中，
预览由 JEP 424 提出并集成到了 Java 19 中。


Foreign Function & Memory API (FFM API) 定义了类和接口：

分配外部内存：MemorySegment、MemoryAddress和SegmentAllocator；
操作和访问结构化的外部内存：MemoryLayout, VarHandle；
控制外部内存的分配和释放：MemorySession；
调用外部函数：Linker、FunctionDescriptor和SymbolLookup。
 */

public class Solution424 {

    public static void main(String[] args) {

        /*
        下面是 FFM API 使用示例，这段代码获取了 C 库函数的 radixsort 方法句柄，
        然后使用它对 Java 数组中的四个字符串进行排序。
         */

        /*
        // 1. 在C库路径上查找外部函数
        Linker linker = Linker.nativeLinker();
        SymbolLookup stdlib = linker.defaultLookup();
        MethodHandle radixSort = linker.downcallHandle(stdlib.lookup("radixsort"), ...);
        // 2. 分配堆上内存以存储四个字符串
        String[] javaStrings   = { "mouse", "cat", "dog", "car" };
        // 3. 分配堆外内存以存储四个指针
        SegmentAllocator allocator = implicitAllocator();
        MemorySegment offHeap  = allocator.allocateArray(ValueLayout.ADDRESS, javaStrings.length);
        // 4. 将字符串从堆上复制到堆外
        for (int i = 0; i < javaStrings.length; i++) {
            // 在堆外分配一个字符串，然后存储指向它的指针
            MemorySegment cString = allocator.allocateUtf8String(javaStrings[i]);
            offHeap.setAtIndex(ValueLayout.ADDRESS, i, cString);
        }
        // 5. 通过调用外部函数对堆外数据进行排序
        radixSort.invoke(offHeap, javaStrings.length, MemoryAddress.NULL, '\0');
        // 6. 将(重新排序的)字符串从堆外复制到堆上
        for (int i = 0; i < javaStrings.length; i++) {
            MemoryAddress cStringPtr = offHeap.getAtIndex(ValueLayout.ADDRESS, i);
            javaStrings[i] = cStringPtr.getUtf8String(0);
        }
        assert Arrays.equals(javaStrings, new String[] {"car", "cat", "dog", "mouse"});  // true
         */
    }
}
