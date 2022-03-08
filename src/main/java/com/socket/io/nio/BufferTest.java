package com.socket.io.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author: long
 * @create: 2022-01-07 09:19
 * @Description
 **/

public class BufferTest {

    @Test
    public void test01(){
        //1、创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("--------------------------------");
        //2、put往缓冲区添加数据
        String name = "itheima";
        buffer.put( name.getBytes() );
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        //3、Buffer flip()为：可读模式。将缓冲区界限设置为当前位置，并将当前位置设置为0
        System.out.println("--------------------------------");
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("--------------------------------");
        //4、get数据读取
        char c = (char) buffer.get();
        System.out.println(c);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());


    }

    @Test
    public void test02(){
        ByteBuffer buf = ByteBuffer.allocate(10);
        String n = "itheima";
        buf.put(n.getBytes());
        buf.flip();
        //读取数据
        byte[] b = new byte[2];
        buf.get(b);
        String rs = new String(b);
        System.out.println(rs);
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        buf.mark();
        System.out.println("--------------------------------");
        byte[] b2 = new byte[3];
        buf.get(b2);
        System.out.println(new String(b2));
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        System.out.println("--------------------------------");
        buf.reset();
        if (  buf.hasRemaining() ){
            System.out.println(buf.position());
            System.out.println(buf.limit());
            System.out.println(buf.capacity());
        }

    }

    @Test
    public void test03(){
        //创建直接内存
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        System.out.println( byteBuffer.isDirect() );

    }
}
