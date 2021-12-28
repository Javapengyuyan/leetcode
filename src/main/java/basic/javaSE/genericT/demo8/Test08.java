package basic.javaSE.genericT.demo8;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author: long
 * @create: 2021-12-19 11:13
 * @Description 泛型通配符上限
 **/

public class Test08 {

    public static void main(String[] args) {
        ArrayList<Animal> animals =new ArrayList<>();
        animals.add(new Animal());
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Minicat> minicats = new ArrayList<>();
        /**
         *  通配符上限测试
         */
        //showAnimal(animals);
        showAnimal(cats);
        showAnimal(minicats);
        /**
         * 通配符下限测试
         */
        showAnimalSuper(animals);
        showAnimalSuper(cats);
        //showAnimalSuper(minicats);

    }

    /**
     * 通配符上限
     * 泛型通配符传递集合类型，只能传递 继承类的类型或者子类型
     * @param list
     */
    public static void showAnimal(ArrayList<? extends Cat> list){
        /**
         * 上限不可以填充元素
         */
        //list.add(new Cat());
        //list.add(new Animal());
        for (int i = 0; i < list.size(); i++) {
            Cat cat = list.get(i);
            System.out.println(cat);
        }

    }

    public static void showAnimalSuper( ArrayList<? super Cat> list){
        /**
         * 下限可以填充元素
         */
        list.add(new Cat());
        for (Object o : list) {
            System.out.println(o);
        }

    }


}
