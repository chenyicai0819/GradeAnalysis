package org.example.dao;



import org.apache.commons.dbutils.QueryRunner;
import org.example.service.ReadExcel;
import org.example.service.info.StudentInfoToExcel;
import org.example.service.util.ConfigReader;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class InsterDemo {
    static boolean isInsert = true;
    public static void insterDemo(String sql) {

        File file=null;
        LinkOracle lo=new LinkOracle();
        QueryRunner qr=new QueryRunner(true);


        try {
            LinkOracle.linkOracle();
            file = new File(ConfigReader.getClassName());
            ReadExcel readExcel = new ReadExcel();//创建对象
            List<StudentInfoToExcel> students = readExcel.readExcel(file);
            Object[][] qrList=new Object[students.size()][];



            for(int i=0;i<students.size();i++){
                qrList[i]=new Object[18];
                qrList[i][0]=students.get(i).getGrade_id();
                qrList[i][1]=students.get(i).getTerm();
                qrList[i][2]=students.get(i).getStu_id();
                qrList[i][3]=students.get(i).getStu_name();
                qrList[i][4]=students.get(i).getStu_major();
                qrList[i][5]=students.get(i).getStu_grade();
                qrList[i][6]=students.get(i).getStu_class();
                qrList[i][7]=students.get(i).getCourse_id();
                qrList[i][8]=students.get(i).getCourse_num();
                qrList[i][9]=students.get(i).getCourse_name();
                qrList[i][10]=students.get(i).getGrade_us();
                qrList[i][11]=students.get(i).getGrade_ex();
                qrList[i][12]=students.get(i).getGrade_all();
                qrList[i][13]=students.get(i).getGrade_value();
                qrList[i][14]=students.get(i).getEx_gene();
                qrList[i][15]=students.get(i).getGrade_gene();
                qrList[i][16]=students.get(i).getText_way();
                qrList[i][17]=students.get(i).getCourse_gene();
            }
            if(isInsert){
                int result = qr.batch(lo.conn,sql,qrList).length;  //批处理
                System.out.println("插入数据库的长度：" + result + "\t" + "Excel表的长度：" + students.size());
                System.out.println("插入成功");
            }else {
                System.out.println("插入失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                lo.conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
