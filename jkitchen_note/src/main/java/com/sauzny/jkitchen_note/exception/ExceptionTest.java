package com.sauzny.jkitchen_note.exception;

public class ExceptionTest {

    public static Class<?> getRealMessage(Throwable e) {
        // 如果e不为空，则去掉外层的异常包装
        while (e != null) {
            Throwable cause = e.getCause();
            if (cause == null) {
                return e.getClass();
            }
            e = cause;
        }
        return null;
    }

    public static void main(String[] args) {

        try {
            new ExceptionC().c();
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println(ExceptionTest.getRealMessage(e).getName());
        }
    }

}
