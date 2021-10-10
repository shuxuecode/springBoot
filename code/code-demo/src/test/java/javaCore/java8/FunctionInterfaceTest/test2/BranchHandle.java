package javaCore.java8.FunctionInterfaceTest.test2;

/**
 * @date 2021/10/10
 */
@FunctionalInterface
public interface BranchHandle {

    /**
     * 分支操作
     *
     * @param trueHandle  为true时要进行的操作
     * @param falseHandle 为false时要进行的操作
     * @return void
     **/
    void trueOrFalseHandle(Runnable trueHandle, Runnable falseHandle);



    public static BranchHandle isTureOrFalse(boolean bool) {
        return (trueHandle, falseHandle) -> {
            if (bool) {
                trueHandle.run();
            } else {
                falseHandle.run();
            }
        };
    }
}
