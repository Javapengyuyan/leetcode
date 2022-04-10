package com.javaBasic.concureent.thread.lambda;

/**
 * @author: long
 * @create: 2022-02-12 22:00
 * @Description 函数式接口逐渐递进
 *
 * 特性：1、一个接口只能有一个实现方法
 *      2、看着简洁
 **/

public class TestLambda {

    //3、静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("3、静态内部类");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();
        like = new Like2();
        like.lambda();

        //4、局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("4、局部内部类");
            }
        }
        like = new Like3();
        like.lambda();
        //5、匿名内部类 必须借助接口和父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("5、匿名内部类");
            }
        };
        like.lambda();
        //6、lambda简化
        like = ()->{
            System.out.println("6、lambda表达式");
        };
        like.lambda();

    }


}
//1、定义一个函数式接口
interface ILike{
    void lambda();
}
//2、实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("1、接口实现类");
    }
}