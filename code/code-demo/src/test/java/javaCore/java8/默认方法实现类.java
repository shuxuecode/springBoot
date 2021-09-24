package javaCore.java8;

/**
 * @Author zsx
 * @Date 2021/2/22
 */
public class 默认方法实现类 implements 默认方法接口 {

//    @Override
//    public String get() {
//        return null;
//    }


    @Override
    public String get() {
        System.out.println("实现方法");
        //return 默认方法接口.super.get();
        return "实现方法返回数据";
    }
}
