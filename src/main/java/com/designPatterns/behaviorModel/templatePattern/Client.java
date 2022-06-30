package com.designPatterns.behaviorModel.templatePattern;

public class Client {

    public static void main(String[] args) {
        /*System.out.println("学生a的试卷");
        TestPaperA testPaperA = new TestPaperA();
        testPaperA.TestQuestion();
        testPaperA.TestQuestion2();
        System.out.println("学生b的试卷");
        TestPaperB testPaperB = new TestPaperB();
        testPaperB.TestQuestion();
        testPaperB.TestQuestion2();*/
        TestQuestion testPaperALast ;
        testPaperALast = new TestPaperALast();
        /**
         * 继承父类方法，重写方法，客户端调用的非子类重写方法
         *
         * 模板方法抽象的为模板，也有可能是一个具体方法，通过子类继承重写来进行传值
         *
         * 把不变行为转移到超类，去除子类中重复的代码
         *
         *
         */
        testPaperALast.testQuestion();
        testPaperALast.testQuestion2();

        testPaperALast = new testPaperBLast();
        testPaperALast.testQuestion();
        testPaperALast.testQuestion2();

    }

}
