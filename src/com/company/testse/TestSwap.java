package com.company.testse;

public class TestSwap {

    public static void main(String[] args) {
        TestClass a = new TestClass("a");
        TestClass b = new TestClass("b");

        swap(a, b);

        System.out.println(a);

        String str = "hello";

        changeStr(str);

        System.out.println(str);

    }

    public static void swap(TestClass a, TestClass b) {
        TestClass swap = a;
        a = b;
        b = swap;
    }

    public static void changeStr(String a) {
        a = "changed";
    }

}
