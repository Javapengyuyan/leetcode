package basic.javaSE.faceObject;

/**
 * @author: long
 * @create: 2022-01-22 17:07
 * @Description
 **/

public class Test {

    public static void main(String[] args) {
        //多态：1、继承、2、重写、3、父类引用指向子类对象  向上转型
        //会产生多个吃东西的形态所以叫多态
        Father father = new Childone();
        father.eat();
        String name = "aaa";
        String name1 = new String("aaa");
        System.out.println(name.equals(name1));
        System.out.println(name==name1);


    }

}
