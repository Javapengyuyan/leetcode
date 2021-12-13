package basic.javaSE.genericT;

/**
 * @author: long
 * @create: 2021-12-11 13:16
 * @Description
 **/

public class Test04 {

    /**
     * 泛型类中T、E、K、V、？分别代表：
     * T-type，代表在调用时的指定类型，会进行推断
     * E-element（元素）在集合中使用，对各方法中泛型进行限制，保证同一对象调用不同方法时操作类型相同。
     * ？-表示不确定java类型，类型统配，不会进行类型推断
     */
    //测试泛型类中：子类继承父类、父类是泛型类，子类是/不是 的情况


    public static void main(String[] args) {
        ChildFirst<String> childFirst = new ChildFirst<>();
        childFirst.setValue("string");
        System.out.println(childFirst.getValue());


        ChildSecond childSecond = new ChildSecond();
        childSecond.setValue(100);
        System.out.println(childSecond.getValue());

    }


}
