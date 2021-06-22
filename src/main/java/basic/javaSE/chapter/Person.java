package basic.javaSE.chapter;

import lombok.Data;

@Data
public class Person {

    private String name;

    private String age;

    public String a;

    protected String b;

    String c;

    private String d;

    public void eat(){
        System.out.println("eat...");
    }

}
