package com.javaBasic.javaSE.equalsTest;

import lombok.Data;

@Data
public class Student {

    private String name;
    private int age;
    private String interest;

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (age != other.age)
            return false;
        if (interest == null) {
            if (other.interest != null)
                return false;
        } else if (!interest.equals(other.interest))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((interest == null) ? 0 : interest.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }


}
