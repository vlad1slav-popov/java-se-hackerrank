package com.company.testintefaceabstractcalss;

public class TestInterface implements InterfaceForTests {


    public static void main(String[] args) {
        TestInterface testInterface = new TestInterface();
        System.out.println(testInterface.getDefaultString());
//        System.out.println(InterfaceForTests.getString());
//        System.out.println();
    }

//    @Override
//    public String getDefaultString() {
//        return "NOT DEFAULT";
//    }
}
