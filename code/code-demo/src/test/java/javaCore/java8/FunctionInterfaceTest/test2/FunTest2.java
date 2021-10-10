package javaCore.java8.FunctionInterfaceTest.test2;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/10/10
 */
public class FunTest2 {


    @Test
    void t() {
        BranchHandle.isTureOrFalse(true).trueOrFalseHandle(() -> {
            System.out.println("执行了true");
        }, () -> {
            System.out.println("执行了 false");
        });

        BranchHandle.isTureOrFalse(false).trueOrFalseHandle(() -> {
            System.out.println("执行了true");
        }, () -> {
            System.out.println("执行了 false");
        });
    }

}
