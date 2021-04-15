package javaCore.java8;

import java.util.UUID;

public class FunTestInterfaceImpl implements FunTestInterface {
    @Override
    public void test() {
        // todo 不执行
        System.out.println(UUID.randomUUID().toString());
    }
}
