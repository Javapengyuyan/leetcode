package basic.thread.demo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author: long
 * @create: 2022-02-11 11:07
 * @Description
 **/

public class TestCallable implements Callable<Boolean> {

    static String url;
    static String name;

    public TestCallable(String url,String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载名为："+name);
        return true;
    }

    public static void main(String[] args) throws Exception {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("执行call方法");
                return "call方法返回值";
            }
        });
        futureTask.run();
        Object o = futureTask.get();
        System.out.println(o);
        TestCallable t1 = new TestCallable("https://download/.jpg", "");
        TestCallable t2 = new TestCallable("https://download/.jpg", "");
        TestCallable t3 = new TestCallable("https://download/.jpg", "");
        /**1、创建执行服务
         * 2、提交执行
         * 3、获取结果
         * 4、关闭服务
         */
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Boolean> result1 = executorService.submit(t1);
        Future<Boolean> result2 = executorService.submit(t2);
        Future<Boolean> result3 = executorService.submit(t3);
        Boolean aBoolean = result1.get();
        Boolean aBoolean1 = result2.get();
        Boolean aBoolean2 = result3.get();
        executorService.shutdown();


    }

}

class WebDownloader{
    public void downloader(String url,String name)  {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
