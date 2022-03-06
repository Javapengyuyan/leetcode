package com.myBatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest {

    public void conn(){
        String url = "http://182.168.10.2:3306/testJDBC";
        String user = "root";
        String passWord = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, passWord);
            String sql = "select * from nk_db.user where name=? and type =?";
            String name = "test";
            String type = "2";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,type);
            ResultSet resultSet = statement.executeQuery();
            //connection.createStatement()
            Object object = resultSet.getObject("age");
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }


    }


}
