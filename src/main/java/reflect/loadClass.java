package reflect;

import com.sun.org.apache.bcel.internal.generic.LoadClass;
import reflect.annotation.Bean;
import reflect.common.ApplicationContext;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class loadClass {

    //定义一个map存储实例
    /*public static Map<Class,Object> beanFactory = new HashMap<>();
    private static String filePath;

    public static void main(String[] args) {
        load();
    }

    //加载全部类实例
    public static void load(){
        filePath = ApplicationContext.class.getClassLoader().getResource("").getFile();
        //System.out.println(filePath);//   打印后为所有目录/D:/IdeaProjects/leetCode/leetcode/target/classes/
        loadOne(new File(filePath));
    }

    public static void loadOne(File fileParent){
        if (fileParent.isDirectory()){
            File[] childrenFiles = fileParent.listFiles();
            if (childrenFiles == null || childrenFiles.length == 0){
                return;
            }
            for (File child : childrenFiles) {
                if (child.isDirectory()){
                    loadOne(child);
                }else {
                    //通过文件路径变成全类名，第一步把绝对路径部分去掉
                    String pathWithClass = child.getAbsolutePath().substring(filePath.length()-1);
                    //选中class文件
                    if (pathWithClass.contains("class")){
                        //把路径中“\”转为“.”，把后缀class删了，变成了类名
                        String fullName = pathWithClass.replaceAll("\\\\",".").replace(".class","");
                        try {
                            Class<?> aClass = Class.forName(fullName);
                            //把接口的类实例化放在Map中
                            //接口不能实例化
                            if (!aClass.isInterface()){
                                Bean annotation = aClass.getAnnotation(Bean.class);
                                if (annotation != null){
                                    Object instance = aClass.newInstance();
                                    beanFactory.put(aClass,instance);
                                }
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

        }

    }*/




}
