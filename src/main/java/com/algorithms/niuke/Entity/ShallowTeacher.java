package com.algorithms.niuke.Entity;

public class ShallowTeacher implements Cloneable{

    private String name;

    private Integer age;

    private Student student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * 浅拷贝
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
        return object;
    }

}
