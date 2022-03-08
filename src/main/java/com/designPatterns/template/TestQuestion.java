package com.designPatterns.template;

public class TestQuestion {

    public void testQuestion(){
        System.out.println("杨过得🗡，后来给了郭靖，练成了倚天屠龙，玄铁可能是：()a,球铁，" +
                "b炼铁，c陨石");
        System.out.println("答案是"+Answer1());
    }

    protected String Answer1(){
        return "";
    }

    public void testQuestion2(){
        System.out.println("杨过铲除了情花，造成()a植物不再害人，b物种灭绝");
        System.out.println("答案是"+Answer2());
    }

    protected String Answer2(){
        return "";
    }


}
