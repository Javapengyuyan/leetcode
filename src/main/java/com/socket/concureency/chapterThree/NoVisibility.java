package com.socket.concureency.chapterThree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 没有共享可能导致重排序，读取不到，或者读到0
 *
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        public void run(){
            while (!ready){
                Thread.yield();
            }
            System.out.println(number);

        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }



    //3.3.3
    private static ThreadLocal<Connection> connectionThreadLocal
            = new ThreadLocal<Connection>(){
        public Connection initialValue(){
            try {
                return DriverManager.getConnection("DB_URL");
            } catch (SQLException e) {
                return null;
            }
        }
    };
    public static Connection getConnection(){
        return connectionThreadLocal.get();
    }



}
