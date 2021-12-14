package basic.javaSE.genericT.demo5;

/**
 * @author: long
 * @create: 2021-12-13 20:36
 * @Description
 **/

public class Test05 {

    /**
     * 泛型标识，
     *
     */
    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(apple.getKey());

        Pair<String,Integer> pair = new Pair("a",1);
        String key = pair.getKey();
        Integer value = pair.getValue();
        System.out.println(key);
        System.out.println(value);

    }

}
