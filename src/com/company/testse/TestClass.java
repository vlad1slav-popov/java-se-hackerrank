package com.company.testse;

public class TestClass {

    private String name;


    public TestClass(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
