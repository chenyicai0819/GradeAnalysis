package org.example.manager;


import org.example.dao.DeleteDemo;
import org.example.dao.InsterDemo;
import org.example.dao.SelectDemo;
import org.example.dao.UpdateDemo;
import org.example.service.ExcelUtil;
import org.example.service.WriteExcel;

public class startJDBC {
    public static void main(String[] args) {
        //DeleteDemo.deleteDemo("DELETE FROM grades");//删除语句
        //InsterDemo.insterDemo("INSERT INTO grades VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");//输入语句
        //SelectDemo.selectDemo("SELECT * FROM grades WHERE stu_name='黄纪晟'");//查询语句
        WriteExcel.fun1("SELECT * FROM grades WHERE stu_name='黄纪晟'");//查询并输出excel
        // UpdateDemo.updateDemo("UPDATE yuangong SET YG_ID=1023 WHERE YG_ID=23");//更新语句
    }
}
