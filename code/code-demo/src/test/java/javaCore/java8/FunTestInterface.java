package javaCore.java8;

/**
 * @FunctionalInterface 只能标记在“有且仅有包含一个抽象方法”的接口上
 */
@FunctionalInterface
public interface FunTestInterface {
    /**
     * 唯一的抽象方法
     */
    void test();

    //  java.lang.Object中的方法不是抽象方法
    public boolean equals(Object obj);

    // default不是抽象方法
    public default void defaultMethod() {
    }

    // static不是抽象方法
    public static void staticMethod() {
    }
}
