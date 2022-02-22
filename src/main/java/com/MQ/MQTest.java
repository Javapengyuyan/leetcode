package com.MQ;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;

import java.io.IOException;

/**
 * @author: long
 * @create: 2022-02-22 13:27
 * @Description
 **/

public class MQTest {
    public static void main(String[] args) {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        Connection connection = factory.createConnection();
        Channel channel = connection.createChannel(false);
        try {
            /**
             * 当前信道设置为事务
             * 提交事务
             * 事务回滚
             */
            channel.txSelect();
            channel.txCommit();
            channel.txRollback();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
