package com.designPatterns.structalModel.AdapterPattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: long
 * @create: 2022-06-30 11:05
 * @Description
 **/
@Slf4j
public class Guards extends Player{
    public Guards(String name) {
        super(name);
    }

    @Override
    public void Attack() {
        log.info("后卫{}进攻",name);
    }

    @Override
    public void Defense() {
        log.info("后卫{}进攻",name);
    }
}
