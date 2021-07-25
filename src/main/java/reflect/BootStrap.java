package reflect;

import reflect.common.ApplicationContext;
import reflect.service.IBookService;
import reflect.service.impl.IBookServiceImpl;

public class BootStrap {

    public static void main(String[] args) {
        //测试反射读取配置文件加载实例对象
        ApplicationContext applicationContext = new ApplicationContext();
        applicationContext.initContextByAnnotation();
        //"reflect.service.impl.IBookServiceImpl"
        //System.out.println(IBookServiceImpl.class.getName());
        Object bean = applicationContext.getBean(IBookServiceImpl.class);
        System.out.println(bean);
    }

}
