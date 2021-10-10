package javaCore.ExceptionTest;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/10/10
 */
public class ExceptionInterfaceTest {


    @Test
    void t() {
        ExceptionInterface exceptionInterface = new ExceptionInterfaceImpl();
        try {
            exceptionInterface.test("");
        } catch (MyException e) {
            System.out.println(e.getCode());
            System.out.println(e.getMsg());
        }
    }

    @Test
    void t2() {
        ExceptionInterface exceptionInterface = new ExceptionInterfaceImpl();
        exceptionInterface.demo("");
        try {
        } catch (MyException e) {
            System.out.println(e.getCode());
            System.out.println(e.getMsg());
        }
    }
}
