package basic.javaSE.genericT;

/**
 * @author: long
 * @create: 2021-12-12 18:08
 * @Description 子类不是泛型类时候，父类类型不明确时候为object类型，否则要明确类型
 **/

public class ChildSecond extends Parent<Integer> {
    /*@Override
    public Object getValue() {
        return super.getValue();
    }*/

    @Override
    public Integer getValue() {
        return super.getValue();
    }
}
