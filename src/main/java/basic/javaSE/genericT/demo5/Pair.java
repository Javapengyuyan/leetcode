package basic.javaSE.genericT.demo5;

/**
 * @author: long
 * @create: 2021-12-13 20:42
 * @Description 接口是泛型类，实现类也是泛型类：则要保证实现类的标识包含接口的标识
 **/

public class Pair<T,E> implements Generator<T> {

    private T key;
    private E value;

    public Pair(T key, E value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public T getKey() {
        return key;
    }

    public E getValue(){
        return value;
    }

}
