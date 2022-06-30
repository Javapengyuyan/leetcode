package com.designPatterns.behaviorModel.templatePattern;

public class TestPaperA {

    /**
     * 模板方法模式
     *
     * 使用抽象类将公共类和方法抽象为模板，子类只需要写实现
     *
     * 抄写试卷-输出答案-》模板方法抽象-继承输出答案
     *
     */
    public void TestQuestion(){
        System.out.println("杨过得🗡，后来给了郭靖，练成了倚天屠龙，玄铁可能是：()a,球铁，" +
                "b炼铁，c陨石");
        System.out.println("答案是b");

    }

    public void TestQuestion2(){
        System.out.println("杨过铲除了情花，造成()a植物不再害人，b物种灭绝");
        System.out.println("答案是b");
    }

}
