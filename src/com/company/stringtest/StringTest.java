package com.company.stringtest;

public class StringTest {

    public static void main(String[] args) {
//        String test = "I/O error on GET request for \"http://localhost:20004/alive\":";
//        String result = test.substring(test.indexOf('"') + 1, test.lastIndexOf('"'));
//        System.out.println(result);

        String test1 = "/adminpanel/test/pc";
//        test1 = test1.replace("adminpanel/", "");
//        System.out.println(test1);




        String  test2 = "/adminpanel";

        String test3 = "adminpanel";

        boolean contains = test1.contains(test2);
//        System.out.println(contains);


    }
}
