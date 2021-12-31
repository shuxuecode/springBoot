package com.zsx;

import com.zsx.spi.SpiDemo;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * spi全称Service Provider Interface， 服务提供接口，
 * 是Java提供的一套用来被第三方实现或者扩展的API。
 * <p>
 * JDK 中 提供了一个 SPI 的功能，核心类是 java.util.ServiceLoader。
 * 其作用就是，可以通过类名获取在"META-INF/services/"下的多个配置实现文件。
 * <p>
 * **jdk默认的spi机制的缺点：**
 * 由于这个加载顺序（classpath）是由用户指定的，
 * 所以无论我们加载第一个还是最后一个，都有可能会导致加载不到用户自定义的那个配置。
 * 所以这也是JDK SPI机制的一个劣势，无法确认具体加载哪一个实现，也无法加载某个指定的实现，
 * 仅靠ClassPath的顺序是一个非常不严谨的方式
 */
public class SpiTestMain {

    public static void main(String[] args) {

        ServiceLoader<SpiDemo> serviceLoader = ServiceLoader.load(SpiDemo.class);
        System.out.println(serviceLoader.toString());
        //Iterator<SpiDemo> iterator = serviceLoader.iterator();
        //while (iterator.hasNext()) {
        //    System.out.println(1);
        //    // 加载并初始化实现类
        //    SpiDemo spiDemo = iterator.next();
        //    spiDemo.test();
        //}

        serviceLoader.forEach(item -> item.test());

    }
}
