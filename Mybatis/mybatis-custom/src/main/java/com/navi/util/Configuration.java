package com.navi.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Configuration Class
 *
 * @author navi
 * @date 2018/11/12
 */
public class Configuration {

    private static Connection con;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kkb", "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() {
        return con;
    }
}
