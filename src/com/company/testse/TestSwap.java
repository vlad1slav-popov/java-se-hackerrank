package com.company.testse;

import java.math.BigDecimal;

public class TestSwap {

    public static void main(String[] args) {
        TestClass a = new TestClass("a");
        TestClass b = new TestClass("b");

        swap(a, b);

        System.out.println(a);

        String str = "hello";

        changeStr(str);

        System.out.println(str);

        BigDecimal bigDecimal = new BigDecimal("1.00");
        BigDecimal bigDecimal1 = bigDecimal.multiply(new BigDecimal("100"));
        System.out.println(bigDecimal1.intValue());

        String s = String.valueOf(bigDecimal.multiply(BigDecimal.valueOf(100)).intValue());
        System.out.println(s);

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
