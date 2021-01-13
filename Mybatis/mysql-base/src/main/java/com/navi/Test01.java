package com.navi;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Test01 Class
 *
 * @author ganxf
 * @date 2019-11-04
 */
public class Test01 {

    public static void main(String[] args)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Dept> list = new ArrayList<>();

        try {

            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 创建链接
            connection = DriverManager.getConnection("jdbc:mysql://mysqlOS:3306/test", "root", "123456");

            // simple statement
            // Statement statement = connection.createStatement();
            // boolean b = statement.execute("select * from dept");
            // resultSet = statement.getResultSet();

            // prepared statement
            // 获取预编译statement
            preparedStatement = connection.prepareStatement("select * from dept where id = ?");
            // 设置参数
            preparedStatement.setInt(1, 1);
            // 执行sql
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Dept dept = new Dept();

                int anInt = resultSet.getInt(1);
                dept.setId(anInt);
                int anInt1 = resultSet.getInt(2);
                dept.setDeptNo(anInt1);
                String string = resultSet.getString(3);
                dept.setDeptName(string);
                String string1 = resultSet.getString(4);
                dept.setLocation(string1);

                list.add(dept);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                    preparedStatement.close();
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }


        }

        for (Dept d :list){
            System.out.println(d.toString());
        }




    }
}
