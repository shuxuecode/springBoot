package javaCore.reflectTest;

import javaCore.reflectTest.handler.TestInvocationHandler;
import javaCore.reflectTest.impl.TestServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

public class Test {

    @org.junit.Test
    public void test() {

        // 业务对象
        TestService testService = new TestServiceImpl();
        // 增强类对象
        TestInvocationHandler testInvocationHandler = new TestInvocationHandler();
        // 将业务对象设置到增强类对象中使用
        testInvocationHandler.setTarget(testService);

        // 得到代理后的对象
        /*
        参数说明：
        1、类加载器，使用默认的即可
        2、接口数组
        3、增强类对象
         */
        TestService proxy = (TestService) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                testService.getClass().getInterfaces(),
                testInvocationHandler
        );

        // 执行方法
        proxy.test();
    }


    @org.junit.Test
    public void test2() throws Exception {
        // 代理类生成class文件
        Class<TestServiceImpl> testServiceClass = TestServiceImpl.class;
        String proxyName = "TestServiceProxy";

        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, testServiceClass.getInterfaces());

        String path = testServiceClass.getResource(".").getPath();

        System.out.println(path);

        FileOutputStream out = new FileOutputStream(path + proxyName + ".class");
        out.write(classFile);
        out.close();


    }

}
