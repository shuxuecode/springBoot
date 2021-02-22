package javaCore.java8;

/**
 * @Author zsx
 * @Date 2021/2/22
 */
public class 默认方法测试类 {

    public static void main(String[] args) {

        默认方法接口 aaa = new 默认方法实现类();

        String s = aaa.get();

        System.out.println(s);

    }
}
