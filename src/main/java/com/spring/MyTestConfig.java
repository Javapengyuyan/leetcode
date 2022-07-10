package com.spring;

import com.spring.testDomain.Car;
import com.spring.testDomain.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: long
 * @create: 2022-06-08 09:25
 * @Description 测试Configuration注解和@Component注解
 **/
@Configuration

public class MyTestConfig {

    @Bean
    public Driver driver(){
        Driver driver = new Driver();
        driver.setId(1);
        driver.setName("driver");
        driver.setCar(car());
        return driver;
    }

    @org.springframework.context.annotation.Bean
    public Car car(){
        Car car = new Car();
        car.setId(1);
        car.setName("car");
        return car;
    }

}
