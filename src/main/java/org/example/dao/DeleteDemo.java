package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDemo {
    public static void deleteDemo(String sql) {
        LinkOracle lo=new LinkOracle();
        Statement stmt=null;

        try {
            LinkOracle.linkOracle();
            stmt=lo.conn.createStatement();
            int a=stmt.executeUpdate(sql);
            System.out.println("删除了"+a+"条数据");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                lo.conn.close();
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
