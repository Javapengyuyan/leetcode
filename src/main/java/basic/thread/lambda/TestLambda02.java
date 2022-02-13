package basic.thread.lambda;

/**
 * @author: long
 * @create: 2022-02-12 22:36
 * @Description
 **/

public class TestLambda02 {
    public static void main(String[] args) {
        Like02 like02 = new ILambda();

        like02 = new Like02(){
            @Override
            public void lambda(String name) {
                System.out.println("有参lambda"+name);
            }
        };
        // 匿名内部类变为lambda表达式
        like02 = (String name)->{System.out.println("有参lambda"+name);};
        like02.lambda("测试");

        //lambda表达式简化 1、去掉参数类型
        like02 = (a)->{
            System.out.println("有参lambda"+a);
        };
        like02.lambda("521");
        //lambda表达式简化 2、去掉括号
        like02 = a ->{
            System.out.println("有参lambda"+a);
        };
        like02.lambda("521");
        //lambda表达式简化 3、去掉花括号
        like02 = a -> System.out.println("有参lambda"+a);
        like02.lambda("521");

        /**
         * 简化前提：接口为函数式接口（即只有一个实现方法）！！！
         * 1、去掉花括号只能有一行代码。
         * 2、多个参数，去掉参数类型同时去掉
         *
         */

    }

}

interface Like02{
    void lambda(String name);
}

class ILambda implements Like02{
    @Override
    public void lambda(String name) {
        System.out.println("有参lambda"+name);
    }
}
