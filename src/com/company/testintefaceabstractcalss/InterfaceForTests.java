package com.company.testintefaceabstractcalss;

public interface InterfaceForTests {


    static String getString() {
        return "OK";
    }

    default String getDefaultString() {
        return "DEFAULT";
    }

}
