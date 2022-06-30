package com.designPatterns.structalModel.AdapterPattern;

/**
 * @author: long
 * @create: 2022-06-30 10:24
 * @Description 适配器模式---实现设计不完美，导致后期需要适配
 *              感觉就是基于向上造型+代理实现？
 **/

public class AdapterDemo {
    public static void main(String[] args) {
        Player b = new Forwards("巴蒂尔");
        b.Attack();
        Player m = new Guards("麦克雷");
        m.Attack();
        Player y = new Center("姚明");
        y.Attack();
        y.Defense();
        Player ym = new Translator("大姚");
        ym.Attack();
        ym.Defense();

    }
}
