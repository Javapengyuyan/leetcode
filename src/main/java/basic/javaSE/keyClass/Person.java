package basic.javaSE.keyClass;

import lombok.Data;

@Data
public class Person {
    int id;
    String name;
    /**
     * static修饰变量后，这个变量就属于类不是属于
     *
     *
     */
    static int age;

}
