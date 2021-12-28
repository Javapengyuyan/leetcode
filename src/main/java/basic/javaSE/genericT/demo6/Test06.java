package basic.javaSE.genericT.demo6;

import basic.javaSE.genericT.ProductGetter;

import java.util.ArrayList;

/**
 * @author: long
 * @create: 2021-12-14 22:51
 * @Description
 **/

public class Test06<T> {

    /**
     * 泛型方法：
     * 修饰符 <T/E/K/V> 返回值类型 方法名(形参列表){
     *     方法体。。
     * }
     *
     * 1、只有包含<T>的方法才是泛型方法
     *
     */
    public static void main(String[] args) {
        ProductGetter<Integer> productGetter = new ProductGetter();
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("电脑");
        arrayList.add("机器人");
        arrayList.add("手机");
        //泛型方法的调用，类型是通过调用方法时候来指定的
        String product = productGetter.getProduct(arrayList);
        System.out.println(product);

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(100);
        arrayList1.add(200);
        arrayList1.add(300);
        System.out.println(productGetter.getProduct(arrayList1));

        ProductGetter.printType(100,"string",false);
        //可变参数的泛型方法调用
        ProductGetter.print(1,3,4);
        ProductGetter.print("a","b","c");

    }




}
