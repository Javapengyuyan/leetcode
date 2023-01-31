package com.jvm;

import java.io.InputStream;

/**
 * @author: long
 * @create: 2022-12-22 17:24
 * @Description 不同的类加载器加载同一个class文件，这两个类也会不相同
 **/

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);

                }catch (Exception e){
                    throw new ClassNotFoundException();
                }
            }

        };

        //加载同一个路径下的文件
        Object obj = myLoader.loadClass("com.jvm.JavaVMStackOOM").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.jvm.JavaVMStackOOM );

    }
}
