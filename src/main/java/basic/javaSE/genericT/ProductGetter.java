package basic.javaSE.genericT;

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

    public T getProduct(){
        product = arrayList.get(random.nextInt(arrayList.size()));
        return product;
    }

}
