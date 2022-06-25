package com.javaBasic.concureent.concureencyPratice.chapterTwo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ThreadLocalTest {

    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>(){

        @Override
        public Connection initialValue() {
            try {
                return DriverManager.getConnection("URL");
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    };

    public static Connection getConnection(){

        return connectionThreadLocal.get();
    }


}
