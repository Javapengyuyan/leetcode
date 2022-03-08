package com.spring.SPI;

/**
 * @author: long
 * @create: 2022-03-08 13:26
 * @Description
 **/

public class SpiImpl2 implements SPIService{
    @Override
    public void execute() {
        System.out.println("SpiImpl2.execute()");
    }
}
