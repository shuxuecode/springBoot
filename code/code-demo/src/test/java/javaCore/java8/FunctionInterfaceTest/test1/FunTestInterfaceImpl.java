package javaCore.java8.FunctionInterfaceTest.test1;

import java.util.UUID;

public class FunTestInterfaceImpl implements FunTestInterface {
    @Override
    public void test() {
        // todo 不执行
        System.out.println(UUID.randomUUID().toString());
    }
}
