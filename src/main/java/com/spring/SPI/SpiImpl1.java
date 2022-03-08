package com.spring.SPI;

/**
 * @author: long
 * @create: 2022-03-08 13:25
 * @Description
 **/

public class SpiImpl1 implements SPIService {
    @Override
    public void execute() {
        System.out.println("SpiImpl1.execute()");
    }
}
