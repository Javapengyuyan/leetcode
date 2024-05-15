package com.personal.leetcode.Test;

import com.algorithms.niuke.Entity.DeepTeacher;
import com.algorithms.niuke.Entity.Student;
import com.algorithms.niuke.Entity.ShallowTeacher;

public class Clone {

    /**
     * 深拷贝、浅拷贝测试
     * @param args
     */
    public static void main(String[] args) {
        try {
            Student student = new Student();
            student.setName("学生本体");
            ShallowTeacher shallowTeacher = new ShallowTeacher();
            shallowTeacher.setName("老师本体");
            shallowTeacher.setAge(18);
            shallowTeacher.setStudent(student);
            ShallowTeacher shallowTeacherClone = (ShallowTeacher) shallowTeacher.clone();
            shallowTeacherClone.setName("克隆人");
            shallowTeacherClone.setAge(1);
            System.out.println(shallowTeacher);
            System.out.println("teacher.getName:"+ shallowTeacher.getName()+" "+ shallowTeacher.getAge()+" teacher.getStudent:"+ shallowTeacher.getStudent().getName());
            //可以看到创建了新的引用地址
            System.out.println(shallowTeacherClone);
            System.out.println("teacherClone.getName:"+ shallowTeacherClone.getName()+" "+ shallowTeacherClone.getAge()
                    +" teacherClone.getStudent:"+ shallowTeacherClone.getStudent().getName());
            System.out.println("-----------------修改原始引用地址----------");
            student.setName("改名为无名");
            //可以看出改变引用地址后，本体和克隆体都改变了
            System.out.println("teacher.getName:"+ shallowTeacher.getName()+" "+ shallowTeacher.getAge()+" teacher.getStudent:"+ shallowTeacher.getStudent().getName());
            System.out.println("teacherClone.getName:"+ shallowTeacherClone.getName()+" "+ shallowTeacherClone.getAge()
                    +" teacherClone.getStudent:"+ shallowTeacherClone.getStudent().getName());


            DeepTeacher deepTeacher = new DeepTeacher();
            deepTeacher.setName("老师本体--深拷贝");
            deepTeacher.setAge(18);
            deepTeacher.setStudent(student);
            DeepTeacher deepTeacherClone = (DeepTeacher) deepTeacher.clone();
            deepTeacherClone.setName("克隆人--深拷贝");
            deepTeacherClone.setAge(1);
            System.out.println(deepTeacher);
            System.out.println("deepTeacher.getName:"+ deepTeacher.getName()+" "+ deepTeacher.getAge()+" deepTeacher.getStudent:"+ deepTeacher.getStudent().getName());
            //可以看到创建了新的引用地址
            System.out.println(deepTeacherClone);
            System.out.println("deepTeacherClone.getName:"+ deepTeacherClone.getName()+" "+ deepTeacherClone.getAge()
                    +" deepTeacherClone.getStudent:"+ deepTeacherClone.getStudent().getName());
            System.out.println("-----------------修改原始引用地址----------");
            student.setName("deepTeacher--深克隆");
            //可以看出改变引用地址后，本体改变了，克隆体没有改变
            System.out.println("deepTeacher.getName:"+ deepTeacher.getName()+" "+ deepTeacher.getAge()+" deepTeacher.getStudent:"+ deepTeacher.getStudent().getName());
            System.out.println("deepTeacherClone.getName:"+ deepTeacherClone.getName()+" "+ deepTeacherClone.getAge()
                    +" deepTeacherClone.getStudent:"+ deepTeacherClone.getStudent().getName());





        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }


}
