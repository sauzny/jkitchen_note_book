package com.sauzny.jkitchen_note.oak.trycatchfinally;

public class TryCatchFinally {

	
	@SuppressWarnings("finally")
    public static final String test() {
        String t = "";

        try {
            t = "try";
            Integer.parseInt("2");
            return t;
        } catch (NullPointerException e) {
            t = "catch";
            return t;
        } finally {
            t = "finally";
            //return "aaa";
        }
    }

    public static void main(String[] args) {
        System.out.print(TryCatchFinally.test()+"1");
        System.out.println("1223");
    }
}
