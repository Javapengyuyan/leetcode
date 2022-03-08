package TuLing.Fouth;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainStat {

    public static void main(String[] args) {
        //加载Spring 上下文
        //区别：实现了国际化
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        Car car = context.getBean("car",Car.class);

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //beanFactory.registerBeanDefinition();
        //beanFactory.getBean();


    }


}
