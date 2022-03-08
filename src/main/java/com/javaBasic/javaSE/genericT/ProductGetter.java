package com.javaBasic.javaSE.genericT;

import java.util.ArrayList;
import java.util.Random;

/**
 * 抽奖器泛型类
 * @author: long
 * @create: 2021-12-09 21:14
 **/

public class ProductGetter<T> {

    Random random = new Random();

    private T product;

    ArrayList<T> arrayList = new ArrayList<>();

    public void addProduct(T list){
        arrayList.add(list);
    }
    /**
     *  这个方法只是返回结果是泛型，并不是泛型方法
     *
     */
    public T getProduct(){
        product = arrayList.get(random.nextInt(arrayList.size()));
        return product;
    }

    /**
     * 定义泛型方法
     * @param arrayList 传入参数
     * @param <E> 返回泛型结果
     * @return
     */
    public <E> E getProduct(ArrayList<E> arrayList){
        return arrayList.get(random.nextInt(arrayList.size()));
    }

    public static <T,E,K> void printType(T t,E e,K k){
        System.out.println(t + "/" +t.getClass().getSimpleName());
        System.out.println(e + "/" +e.getClass().getSimpleName());
        System.out.println(k + "/" +k.getClass().getSimpleName());
    }

    /**
     * 泛型方法可变参数的定义
     * @param e
     * @param <E>
     */
    public static <E> void print(E... e){
        for (int i=0;i<e.length;i++){
            System.out.println(e[i]);
        }
    }


}
