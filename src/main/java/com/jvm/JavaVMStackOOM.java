package com.jvm;

/**
 * @author: long
 * @create: 2022-12-19 19:28
 * @Description -Xss2M
 **/

public class JavaVMStackOOM {

    private void dontStop(){
        while (true){

        }
    }


    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
        javaVMStackOOM.stackLeakByThread();
    }

}
