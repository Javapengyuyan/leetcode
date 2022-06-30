package com.designPatterns.structalModel.AdapterPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: long
 * @create: 2022-06-30 11:02
 * @Description
 **/
@Slf4j
public class Center extends Player{
    public Center(String name) {
        super(name);
    }

    @Override
    public void Attack() {
        log.info("中锋{}进攻",name);
    }

    @Override
    public void Defense() {
        log.info("中锋{}防守",name);
    }
}
