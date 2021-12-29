package basic.javaSE.genericT.demo7;

/**
 * @author: long
 * @create: 2021-12-16 23:29
 * @Description
 **/

public class Test07 {

    /**
     * 泛型类里面的泛型类型不同，本质上都是泛型类类型，因此不能重载
     *
     * @param args
     */

    public static void main(String[] args) {
        Box<Number> box = new Box<>();
        box.setFirst(100);
        showBox(box);

    }

    /*public static void showBox(Box<Number> box){
        Number first = box.getFirst();
        System.out.println(first);
    }*/

    /**
     * 不能用继承的思路，会报错
     */
    /*public static void showBox(Box<Integer> box){
        Number first = box.getFirst();
        System.out.println(first);
    }*/

    /**
     *  类型通配符是类型实参，而不是形参，使用？代替具体的类型实参
     * @param box
     */
    public static void showBox(Box<?> box){
        Object first = box.getFirst();
        System.out.println(first);
    }

}
