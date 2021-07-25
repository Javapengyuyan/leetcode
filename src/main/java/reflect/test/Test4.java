package reflect.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Test4 {

    public static void main(String[] args) throws NoSuchMethodException {

        Class dogClass = Dog.class;
        //定义一个My注解，然后获取
        //Annotation annotation = dogClass.getAnnotation(My.class);//这个输出的时拿不到的
        //System.out.println(annotation.getClass().getName());

        Method declaredMethod = dogClass.getDeclaredMethod("eat");
        Annotation[] annotations = declaredMethod.getAnnotations();
        for (Annotation annotation1 : annotations) {
            System.out.println(annotation1);
        }

        // 注解My中的注解Retention定义的为运行时，Override注解则为source编译时检查

    }

}
