package com.company.testintefaceabstractcalss;

public class TestInterface implements InterfaceForTests {


    public static void main(String[] args) {
        TestInterface testInterface = new TestInterface();
        System.out.println(testInterface.getDefaultString());
//        System.out.println(InterfaceForTests.getString());
//        System.out.println();

        String get = getSomething();
        System.out.println(get);

    }



//    @Override
//    public String getDefaultString() {
//        return "NOT DEFAULT";
//    }


    public static String getSomething() {
        try {
            return "OK";
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            System.out.println("I`m here.");
        }
        return "NEI+OK";
    }


}
