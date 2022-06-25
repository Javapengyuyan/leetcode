package com.javaBasic.concureent.concureencyPratice.chapterThree;

import java.util.Vector;

public class VectorTest {

    public void testVector(Vector vector){
        synchronized (vector){
            for (int i=0;i<vector.size();i++){
                System.out.println(vector.get(i));
            }
        }
    }



}
