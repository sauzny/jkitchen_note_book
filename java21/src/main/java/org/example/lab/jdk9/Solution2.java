package org.example.lab.jdk9;

/**
 私有接口方法
 注意的是，私有接口方法不能被实现接口的类或其他类直接调用。它们仅用于在接口内部共享代码逻辑，提供更好的代码组织和代码重用。
 */

public interface Solution2 {
    // 公共的默认方法
    int add(int a, int b);

    default int subtract(int a, int b) {
        return add(a, negate(b));
    }

    default int multiply(int a, int b) {
        return a * b;
    }

    // 私有接口方法
    private int negate(int number) {
        return -number;
    }
}
