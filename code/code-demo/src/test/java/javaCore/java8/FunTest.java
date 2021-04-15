package javaCore.java8;

public class FunTest {


    public static void main(String[] args) {

        FunTestInterface funTestInterface = () -> {
            System.out.println("实现");
        };
// TODO zsx
        funTestInterface.test();

    }
}
