package com.designPatterns.structalModel.AdapterPattern;

/**
 * @author: long
 * @create: 2022-06-30 10:27
 * @Description
 **/

public abstract class Player {

    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract void Attack();

    public abstract void Defense();

}
