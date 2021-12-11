package basic.javaSE.genericT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericTest {

    public static void main(String[] args) {
        /**
         * 虽然传入不同的泛型实参，但并没有生成不同的类型，传入不同泛型实参的泛型类
         * 在内存上只有一个，还是原来基本类型。
         * 泛型只是作用于代码编译阶段，泛型信息不会进入到运行时阶段
         *
         * 泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
         */

        //泛型类在创建对象的时候没有指定类型，将按照object类型来操作
        Box box = new Box("string");

        //泛型类不支持基本数据类型，
        //Box<int> box2 = new Box("string");

        //泛型类复用
        Box<String> name = new Box<>("corn");
        Box<Integer> age = new Box<>(2021);
        System.out.println("name class:"+name.getClass());
        System.out.println("name class:"+age.getClass());
        //同一泛型类，根据不同的数据类型创建的对象，本质是同一类型
        System.out.println(name.getClass() == age.getClass());

        Box<Number> numberBox = new Box<>(99);
        System.out.println(numberBox.getData());
        System.out.println(age.getData());
        Collections.copy(null,null);



    }

}
class Box<T>{

    private T data;

    public Box(){

    }

    public Box(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }


}
