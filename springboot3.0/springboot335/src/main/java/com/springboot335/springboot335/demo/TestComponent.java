package com.springboot335.springboot335.demo;

public class TestComponent {

    private String a;
    private String b;

    public String testGet() {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        return "get a=" + a + " b=" + b;
    }


    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }
}
