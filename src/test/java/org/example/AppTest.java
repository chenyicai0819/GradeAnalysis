package org.example;

import static org.junit.Assert.assertTrue;

import org.example.service.ReadExcel;
import org.example.service.info.StudentInfoToExcel;
import org.example.service.util.ConfigReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) {
        File file=null;
        try {
            file = new File(ConfigReader.getClassName());
            ReadExcel readExcel = new ReadExcel();//创建对象
            List<StudentInfoToExcel> students = readExcel.readExcel(file);
            for(StudentInfoToExcel stu:students){

                System.out.print(stu.getGrade_id()+'\t');
                System.out.print(stu.getTerm()+'\t');
                System.out.print(stu.getStu_id()+'\t');
                System.out.print(stu.getStu_name());
                System.out.println();
                System.out.println(students.size());
            }
            /*
            Student student=new Student();
            System.out.println(student.getGrade_id());
            System.out.println(student.getTerm());
            System.out.println(student.getStu_id());
            System.out.println(student.getStu_name());
             */

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
