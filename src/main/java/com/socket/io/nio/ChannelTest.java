package com.socket.io.nio;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: long
 * @create: 2022-01-07 09:35
 * @Description
 **/

public class ChannelTest {

    @Test
    public void write(){
        try {
            //1、字节输出流通向文件
            FileOutputStream fileOutputStream = new FileOutputStream("channel.txt");
            //2、得到字节输出流通道channel
            FileChannel channel = fileOutputStream.getChannel();
            //3、分配缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("BIO通道写入。".getBytes());
            //4、把缓冲区切换成写模式
            byteBuffer.flip();
            channel.write(byteBuffer);
            channel.close();
            System.out.println("写入完成");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void read(){
        try {
            FileInputStream inputStream = new FileInputStream("channel.txt");
            FileChannel channel = inputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(10240);
            int read = channel.read(byteBuffer);
            System.out.println("channel读取返回值："+read);
            String string = new String(byteBuffer.array(),0,byteBuffer.remaining());
            System.out.println(string);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 复制文件
     *
     */
    @Test
    public void copy() throws Exception {
        File srcFile = new File("D:\\Other\\壁纸\\幽鬼.jpg");
        File copyFile = new File("D:\\Other\\壁纸\\幽鬼new.jpg");
        FileInputStream fileInputStream = new FileInputStream(srcFile);
        FileOutputStream fileOutputStream = new FileOutputStream(copyFile);
        FileChannel isChannle = fileInputStream.getChannel();
        FileChannel osChannel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true){
            //先清空缓冲区，再写入缓冲区
            buffer.clear();
            int read = isChannle.read(buffer);
            if (-1 == read){
                break;
            }
            //todo 缓冲区切换到可读模式？？？
            buffer.flip();
            osChannel.write(buffer);
        }
        isChannle.close();
        osChannel.close();
        System.out.println("复制完成");

    }

    public void test02() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("");
        FileChannel channel = fileInputStream.getChannel();



    }



}
