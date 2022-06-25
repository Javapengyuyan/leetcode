package com.spring.testDomain;

import lombok.Data;

/**
 * @author: long
 * @create: 2022-06-08 09:35
 * @Description
 **/

@Data
public class Driver {

    private Integer id;
    private String name;
    private Car car;

}
