package basic.javaSE.keyClass;

import java.text.SimpleDateFormat;

public class ThreadLocalTest {

    public static final ThreadLocal<SimpleDateFormat> sdf =
            new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };



}
