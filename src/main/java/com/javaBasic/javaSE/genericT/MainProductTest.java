package com.javaBasic.javaSE.genericT;

/**
 * @author: long
 * @create: 2021-12-09 21:25
 * @Description 抽奖器泛型类测试
 **/

public class MainProductTest {

    public static void main(String[] args) {
        ProductGetter<String> productGetter = new ProductGetter();
        productGetter.addProduct("手机");
        productGetter.addProduct("榨汁机");
        productGetter.addProduct("手表");
        productGetter.addProduct("电脑");
        String product = productGetter.getProduct();
        System.out.println(product);

        ProductGetter<Integer> integerProductGetter = new ProductGetter<>();
        integerProductGetter.addProduct(1);
        integerProductGetter.addProduct(300);
        integerProductGetter.addProduct(499);
        integerProductGetter.addProduct(588);
        Integer integerProductGetterProduct = integerProductGetter.getProduct();
        System.out.println(integerProductGetterProduct);


    }
}
