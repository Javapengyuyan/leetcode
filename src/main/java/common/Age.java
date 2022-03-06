package common;

import lombok.Data;

/**
 * @author: long
 * @create: 2021-12-30 22:39
 * @Description
 **/
@Data
public class Age implements Cloneable{

    private int age;

    public Age(int age){
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
