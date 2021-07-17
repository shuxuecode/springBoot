package com.zsx;

import com.zsx.spi.SpiDemo;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * spi全称Service Provider Interface， 服务提供接口，
 * 是Java提供的一套用来被第三方实现或者扩展的API。
 */
public class SpiTestMain {

    public static void main(String[] args) {
        ServiceLoader<SpiDemo> serviceLoader = ServiceLoader.load(SpiDemo.class);
        System.out.println(serviceLoader.toString());
        Iterator<SpiDemo> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            System.out.println(1);
            SpiDemo spiDemo = iterator.next();
            spiDemo.test();
        }

    }
}
