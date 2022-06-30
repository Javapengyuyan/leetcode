package com.designPatterns.structalModel.AdapterPattern;

/**
 * @author: long
 * @create: 2022-06-30 11:46
 * @Description
 **/

public class Translator extends Player {

    private ForeignCenter foreignCenter = new ForeignCenter();

    public Translator(String name) {
        super(name);
        foreignCenter.setName(name);
    }

    @Override
    public void Attack() {
        foreignCenter.进攻();
    }

    @Override
    public void Defense() {
        foreignCenter.防守();
    }
}
