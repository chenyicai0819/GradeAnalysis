package org.example;

import org.example.service.WriteExcel;

public class App1 {
    public static void main(String[] args) {
        WriteExcel.fun1("SELECT * FROM grades WHERE stu_name='黄纪晟'");
    }
}
