package basic.javaSE.equalsTest;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        System.out.println("student1和student2是否相等"+student1.equals(student2));

        Student student3 = new Student();
        Student student4 = new Student();
        student2.setName("张三");
        student3.setName("张三");
        student4.setName("张三");

        Set<Student> set = new HashSet<Student>();
        set.add(student1);
        set.add(student2);
        set.add(student3);
        set.add(student4);
        /**
         * 只重写equals方法，不重写hashcode方法，会使set集合存放相同的值，（为4）
         */
        System.out.println(set.size());

        /**
         *  重写hashcode方法后，set集合就为2
         */


        /**
         * 常量池测试
         */
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1")+new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);


    }

}
