package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LinkOracle {
    public static Connection conn=null;
    public static void linkOracle() throws ClassNotFoundException, SQLException {

        String url="jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        String info="george";
        String password="george1234";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn= DriverManager.getConnection(url,info,password);
        if(null != conn){
            System.out.println("连接到数据库 "+conn);
        }
    }

}
