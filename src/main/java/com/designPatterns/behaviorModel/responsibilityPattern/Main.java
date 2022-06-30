package com.designPatterns.behaviorModel.responsibilityPattern;

public class Main {

    /**
     * 责任链模式和建造者模式 配合使用更好
     */
    public static void main(String[] args) {
        Request request = new Request();
        request.setDay(8);
        request.setReason("请假");
        ChainOfResponsibilityClient client = new ChainOfResponsibilityClient();
        Result result = client.execute(request);
        System.out.println("结果："+result.toString());

    }

}
