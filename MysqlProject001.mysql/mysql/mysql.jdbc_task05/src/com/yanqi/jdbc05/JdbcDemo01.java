package com.yanqi.jdbc05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo01 {

    public static void main(String[] arges) throws Exception {

        //1、注册驱动		
        Class.forName("com.mysql.jdbc.Driver");

        //2、获取连接connection连接对象com.mysql.jdbc.JDBC4Connection@188715b5
        String url = "jdbc:mysql://localhost:3306/db4?characterEncoding=UTF-8";
        Connection con = DriverManager.getConnection(url, "root", "123456");

        //3、打印连接对象		
        System.out.println(con);

        //3.获取语句执行平台 Statement
        Statement statement = con.createStatement();

        //3.1 通过 statement对象的 executeUpdate 方法 创建一张表
        String sql = "create table test(id int,name varchar(20),age int);";
        int i = statement.executeUpdate(sql); // 返回值是int类型 表示受影响的行数

        System.out.println(i);

        //4.关闭流
        statement.close();
        con.close();
    }

}

