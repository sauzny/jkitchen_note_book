package org.example.lab.jdk19;


/*
结构化并发的基本 API 是StructuredTaskScope。

StructuredTaskScope 支持将任务拆分为多个并发子任务，在它们自己的线程中执行，并且子任务必须在主任务继续之前完成。
 */

import java.util.concurrent.Future;
//import java.util.concurrent.StructuredTaskScope;

public class Solution428 {

    public static void main(String[] args) {

        /*
        try (var scope = new StructuredTaskScope<Object>()) {
            // 使用fork方法派生线程来执行子任务
            Future<Integer> future1 = scope.fork(task1);
            Future<String> future2 = scope.fork(task2);
            // 等待线程完成
            scope.join();
            // 结果的处理可能包括处理或重新抛出异常
        ... process results/exceptions ...
        } // close
        */
    }
}
