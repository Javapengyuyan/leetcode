package com.spring.SPI;

//import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author: long
 * @create: 2022-03-08 13:33
 * @Description SPI测试
 *
 * SPI ，全称为 Service Provider Interface，是一种服务发现机制。
 * 它通过在ClassPath路径下的META-INF/services文件夹查找文件，自动加载文件里所定义的类。
 *
 *
 **/

public class Test {
    public static void main(String[] args) {
        //Iterator<SPIService> providers = Service.providers(SPIService.class);
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);

        /*while (providers.hasNext()){
            SPIService spiService = providers.next();
            spiService.execute();
        }*/
        System.out.println("----------------------");
        Iterator<SPIService> serviceIterator = load.iterator();
        while (serviceIterator.hasNext()){
            SPIService spiService = serviceIterator.next();
            spiService.execute();
        }

    }
}
