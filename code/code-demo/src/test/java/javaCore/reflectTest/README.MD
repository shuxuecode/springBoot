
- 目前Java开发包中包含了对动态代理的支持, 但是其实现只支持对接口的的实现。其实现主要通过 java.lang.reflect.Proxy 类和 java.lang.reflect.InvocationHandler 接口。
- Proxy 类主要用来获取动态代理对象, InvocationHandler 接口用来约束调用者实现。
- 动态代理是很多框架和技术的基础, spring 的 AOP 实现就是基于动态代理实现的。


### 介绍一下 Proxy 类中最常用的方法 java.lang.reflect.Proxy#newProxyInstance,

该方法返回动态代理类实例. 该方法有三个参数

- loader: the class loader to define the proxy class. 与原始类的类加载器一致
- interfaces: the list of interfaces for the proxy class to implement. 原始类实现的接口
- h: InvocationHandler 实例, 动态代理类实例会调用 InvocationHandler 实例的 invoke 方法



### InvocationHandler 接口中只有一个方法   invoke

该方法有三个参数

- proxy: 动态代理类的实例
- method: 原始类的 Method 实例
- args: 被代理 Method 需要的参数
