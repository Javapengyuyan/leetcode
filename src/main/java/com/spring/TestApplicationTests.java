package com.spring;

import com.spring.testDomain.Car;
import com.spring.testDomain.Driver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: long
 * @create: 2022-06-08 09:47
 * @Description
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestApplicationTests {

    @Autowired
    private Car car;

    @Autowired
    private Driver driver;

    @Test
    public void test(){
        boolean oneComent = driver.getCar() == car;
        System.out.println("是否为同一个类："+oneComent);
    }

}
