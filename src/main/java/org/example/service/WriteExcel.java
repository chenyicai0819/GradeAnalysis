package org.example.service;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.example.dao.LinkOracle;
import org.example.dao.SelectDemo;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WriteExcel {

    public static List<String> outList=new ArrayList<>();
    static String[][] qrListOut =new String[8991][18];


    public static void writeExcel(String sql) {

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

        int j=0;
        for(int i=0;i<outList.size();i++){
            qrListOut[i][0]=outList.get(j);j++;
            qrListOut[i][1]=outList.get(j);j++;
            qrListOut[i][2]=outList.get(j);j++;
            qrListOut[i][3]=outList.get(j);j++;
            qrListOut[i][4]=outList.get(j);j++;
            qrListOut[i][5]=outList.get(j);j++;
            qrListOut[i][6]=outList.get(j);j++;
            qrListOut[i][7]=outList.get(j);j++;
            qrListOut[i][8]=outList.get(j);j++;
            qrListOut[i][9]=outList.get(j);j++;
            qrListOut[i][10]=outList.get(j);j++;
            qrListOut[i][11]=outList.get(j);j++;
            qrListOut[i][12]=outList.get(j);j++;
            qrListOut[i][13]=outList.get(j);j++;
            qrListOut[i][14]=outList.get(j);j++;
            qrListOut[i][15]=outList.get(j);j++;
            qrListOut[i][16]=outList.get(j);j++;
            qrListOut[i][17]=outList.get(j);j++;
            if(j==outList.size()){
                break;
            }
        }


        for(int i=0;i<outList.size();i++){
            for(j=0;j<18;j++){
                //System.out.println(qrListOut);
            }
        }
    }



    public static void exportFeedBack(String[][] qrListOut, String[] title) {
        String fileName = outList.get(2)+outList.get(3)+"成绩汇总" + System.currentTimeMillis() + ".xls"; //文件名
        String sheetName = "反馈明细";//sheet名
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, qrListOut, null);

        //将文件存到指定位置
        try {
            OutputStream os = new FileOutputStream("C:\\Users\\swagg\\IdeaProjects\\GradeAnalysis\\src\\main\\OutputExcel\\" + fileName);
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void fun1(String sql) {
        writeExcel(sql);
        String title[] = {"序号", "学期", "学号","姓名","专业", "年级", "班级","课程代码","课号", "课程名称", "平时成绩","考试成绩","成绩", "学分", "考试类别","成绩类别","考核方式", "课程性质"};
        exportFeedBack(qrListOut,title);
        System.out.println("数据已成功写入表格");
    }

}