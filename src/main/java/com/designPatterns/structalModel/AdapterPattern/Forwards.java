package com.designPatterns.structalModel.AdapterPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: long
 * @create: 2022-06-30 11:01
 * @Description
 **/
@Slf4j
public class Forwards extends Player {

    public Forwards(String name) {
        super(name);
    }

    @Override
    public void Attack() {
        log.info("前锋{}进攻",name);
    }

    @Override
    public void Defense() {
        log.info("前锋{}防守",name);
    }
}
