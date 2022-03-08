package com.javaBasic.javaSE;

public class OuterClass {

    /**
     * 内部类可以定义方法
     * 作用：1、内部类可以隐藏细节和内部结构
     *  2、让封装性更好
     */

    interface HelloWord{
        public void greet();
        public void greetSomone(String someone);
    }

    //1、局部内部类
    public void sayHello(){
        class EnglishGreeting implements HelloWord{
            String name = "World";

            public void greet() {
                greetSomone("Hello World");
            }

            @Override
            public void greetSomone(String someone) {
                System.out.println( "Hello" +name);
            }
        }

        HelloWord getHelloWord = new EnglishGreeting();

        //2、匿名内部类
        HelloWord helloWord = new HelloWord() {
            String name = "tout le monde";
            @Override
            public void greet() {
                greetSomone("tout le monde");
            }

            @Override
            public void greetSomone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        //3、匿名内部类
        HelloWord spain = new HelloWord() {
            String name = "mundo";
            @Override
            public void greet() {
                greetSomone("mundo");
            }

            @Override
            public void greetSomone(String someone) {
                System.out.println("Hloa "+ name);
            }
        };

        getHelloWord.greet();
        helloWord.greetSomone("Freed");
        spain.greet();

    }

    public class InnerClass{
        public String creat(){
            System.out.println("内部类");
            return "";
        }
    }


    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.sayHello();
        //使用外部类才能创建内部类
        InnerClass innerClass = outerClass.new InnerClass();

    }



}
