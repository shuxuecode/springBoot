package javaCore.ExceptionTest;

/**
 * @date 2021/10/10
 */
public class ExceptionInterfaceImpl implements ExceptionInterface {
    @Override
    public String test(String name) {


        throw new MyException("1", "1");
    }

    @Override
    public String demo(String text) throws MyException {


        throw new MyException("2", "2");
    }
}
