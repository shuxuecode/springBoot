package javaCore.reflectTest.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestInvocationHandler implements InvocationHandler {
    // 需要被代理的对象
    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * 实现接口需要重写的方法
     *
     * @param proxy  代理对象
     * @param method 接口中被调用的方法
     * @param args   方法中的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        System.out.println("执行代理前的方法");
        result = method.invoke(target, args);
        System.out.println("执行代理后的方法");

        return result;
    }
}
