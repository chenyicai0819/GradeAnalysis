package org.example.service.info;

import org.apache.poi.xssf.usermodel.XSSFCell;

public class StudentInfoToExcel {
    private String grade_id;
    private String term;
    private String stu_id;
    private String stu_name;
    private String stu_major;
    private String stu_grade;
    private String stu_class;
    private String course_id;
    private String course_num;
    private String course_name;
    private String grade_us;
    private String grade_ex;
    private String grade_all;
    private String grade_value;
    private String ex_gene;
    private String grade_gene;
    private String text_way;
    private String course_gene;

    public StudentInfoToExcel(String grade_id,String term,String stu_id,String stu_name,String stu_major,
                              String stu_grade,String stu_class, String course_id,String course_num,String course_name,
                              String grade_us,String grade_ex,String grade_all, String grade_value,String ex_gene,
                              String grade_gene,String text_way,String course_gene){
        this.grade_id=grade_id;
        this.term=term;
        this.stu_id=stu_id;
        this.stu_name=stu_name;
        this.stu_major=stu_major;
        this.stu_grade=stu_grade;
        this.stu_class=stu_class;
        this.course_id=course_id;
        this.course_num=course_num;
        this.course_name=course_name;
        this.grade_us=grade_us;
        this.grade_ex=grade_ex;
        this.grade_all=grade_all;
        this.grade_value=grade_value;
        this.ex_gene=ex_gene;
        this.grade_gene=grade_gene;
        this.text_way=text_way;
        this.course_gene=course_gene;
    }

    public StudentInfoToExcel(String course_id,String course_gene,String course_name, String grade_value){
        this.course_id=course_id;
        this.course_name=course_name;
        this.grade_value=grade_value;
        this.course_gene=course_gene;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }


    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_major() {
        return stu_major;
    }

    public void setStu_major(String stu_major) {
        this.stu_major = stu_major;
    }



    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(String grade_id) {
        this.grade_id = grade_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_grade() {
        return stu_grade;
    }

    public void setStu_grade(String stu_grade) {
        this.stu_grade = stu_grade;
    }

    public String getStu_class() {
        return stu_class;
    }

    public void setStu_class(String stu_class) {
        this.stu_class = stu_class;
    }

    public String getCourse_num() {
        return course_num;
    }

    public void setCourse_num(String course_num) {
        this.course_num = course_num;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getGrade_us() {
        return grade_us;
    }

    public void setGrade_us(String grade_us) {
        this.grade_us = grade_us;
    }

    public String getGrade_ex() {
        return grade_ex;
    }

    public void setGrade_ex(String grade_ex) {
        this.grade_ex = grade_ex;
    }

    public String getGrade_all() {
        return grade_all;
    }

    public void setGrade_all(String grade_all) {
        this.grade_all = grade_all;
    }

    public String getGrade_value() {
        return grade_value;
    }

    public void setGrade_value(String grade_value) {
        this.grade_value = grade_value;
    }

    public String getEx_gene() {
        return ex_gene;
    }

    public void setEx_gene(String ex_gene) {
        this.ex_gene = ex_gene;
    }

    public String getGrade_gene() {
        return grade_gene;
    }

    public void setGrade_gene(String grade_gene) {
        this.grade_gene = grade_gene;
    }

    public String getText_way() {
        return text_way;
    }

    public void setText_way(String text_way) {
        this.text_way = text_way;
    }

    public String getCourse_gene() {
        return course_gene;
    }

    public void setCourse_gene(String course_gene) {
        this.course_gene = course_gene;
    }


}
