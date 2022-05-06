package com.javaBasic.concureent.utilClass;

import com.javaBasic.javaSE.equalsTest.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author: long
 * @create: 2022-05-06 15:05
 * @Description   java8引入了stream流、lambda表达式
 *
 * 流程：1、数据源。2、数据处理。3、收集结果
 *
 **/

public class StreamDemo {

    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("张三", 18, 2000),
                new Student("李四", 29, 9000),
                new Student("王五", 21, 5000));
        List<Student> newList = new ArrayList<>();
        //查找age<22，salary>3500的
        /**
         * 传统筛选方法：遍历一遍
         */
        for (Student s: studentList) {
            if ( s.getAge()<22 && s.getSalary()>3500){
                newList.add(s);
            }
        }
        /**
         * 使用stream流完成：
         */
        Predicate<Student> predicate1 = student -> student.getAge()<22;
        Predicate<Student> predicate2 = student -> student.getSalary()>3500;
        List<Student> collectList = studentList.stream()
                .filter(predicate1.and(predicate2))//过滤器，and。这是写法一
                //.filter(student -> student.getAge()<22)//这是写法二
                //.filter(student -> student.getSalary()>3500)//这是写法二
                .collect(Collectors.toList());
        System.out.println(collectList);

        //函数式编程，把方法实现当参数
        Thread thread = new Thread( ()->
            System.out.println("拉姆达表达式")
         );

        List<String> stringList = Arrays.asList("hello", "world", "java");
        /**
         * 1、filter方法。可以forEach直接输出
         */
        stringList.stream()
                .filter( str->str.length()>4 )
                .forEach( str-> System.out.println(str) );

        /**
         * 2、limit
         */
        stringList.stream()
                .limit(2)
                .forEach(str-> System.out.println(str));


        List<Integer> integerList = Arrays.asList(3, 1, 5, 8);
        /**
         * 3.1、sort。顺序输出
         */
        integerList.stream()
                .sorted()
                .forEach(i-> System.out.println(i));
        //3.2、sort。倒序输出
        integerList.stream().
                sorted(Comparator.reverseOrder())
                .forEach(i-> System.out.println(i));
        /**
         * 4、求最大最小值
         */
        Integer max = integerList.stream()
                .max(Integer::compareTo)
                .get();
        System.out.println(max);
        Integer min = integerList.stream()
                .min(Integer::compareTo)
                .get();
        System.out.println(min);
        System.out.println(integerList.stream().count());//长度

        /**
         * 5、map---对里面的值进行特定操作
         */
        integerList.stream()
                .map( integer -> integer+10)
                .forEach(integer -> System.out.println(integer));
        //对传入int型方法，有sum方法
        int mapToint = integerList.stream()
                .mapToInt(t -> t + 2)
                .sum();
        System.out.println(mapToint);

        /**
         * 6、reduce
         * 将流中元素反复结合起来，得到一个值
         */
        System.out.println(
                integerList.stream()
                .reduce((sum, num) -> sum + num)
                .get()
        );

        /**
         * 7、collector
         */
        List<Integer> collect = integerList.stream()
                .filter(i -> i > 5)
                .collect(Collectors.toList());
        System.out.println(collect);

    }

}
