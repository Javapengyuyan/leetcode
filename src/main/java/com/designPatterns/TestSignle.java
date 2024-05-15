package com.designPatterns;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestSignle {

    private final static TestSignle INSTANCE = new TestSignle();

    private TestSignle(){};

    public TestSignle getTest(TestSignle testSignle){
        return INSTANCE;
    }


    public static void main(String[] args) {
        Object o = null;
        Optional<Object> optional = Optional.ofNullable(o);
        if (optional.isPresent()){
            System.out.println("存在");
        }else {
            System.out.println("bu");
        }
        String string = optional.toString();
        Class<? extends Optional> optionalClass = optional.getClass();

        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.stream().collect(Collectors.toMap(
            Object::hashCode,Object->Object,
                (obj1,obj2)->obj1
        ));

    }

}
