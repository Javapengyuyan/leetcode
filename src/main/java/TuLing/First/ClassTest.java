package TuLing.First;

public class ClassTest {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());


    }

    /**
     * 双亲委派机制
     *
     * 好处：保证类被加载唯一
     * 确保核心class库被加载（因为先查询父类是否加载了）
     *
     */
    protected Class<?> loadClass(){
        String name = new String();
        synchronized (getClassLoadingLock(name)){
            /*Class<?> c = findloadClass();
            if (c == null){
                if (parent != null){
                    c = parent.loadClass();
                }

            }*/


        }
        return null;
    }

    public Object getClassLoadingLock(String name){

        return null;
    }
}
