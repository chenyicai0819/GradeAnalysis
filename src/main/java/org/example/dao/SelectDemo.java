package org.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectDemo {
    public static List<String> outList=new ArrayList<>();
    public static void selectDemo(String sql) {
        Statement stmt=null;
        ResultSet rs=null;
        ResultSetMetaData md = null;

        LinkOracle lo=new LinkOracle();
        try {
            LinkOracle.linkOracle();
            stmt=lo.conn.createStatement();
            rs=stmt.executeQuery(sql);
            md= rs.getMetaData();//取得结果集列数
            int col=md.getColumnCount();
            String YG_ID="";
            System.out.println(col);
            while (rs.next()){
                for(int i=1;i<=col;i++){
                    YG_ID=rs.getString(i);
                    outList.add(YG_ID);
                }
            }
            int inf=1;
            int anf=0;
            for(String s:outList){
                System.out.print(s+"\t");
                anf++;
                if(anf==18*inf){
                    System.out.println();
                    inf++;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rs.close();
                lo.conn.close();
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
