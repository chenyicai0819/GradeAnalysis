/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2021/4/16 23:12:46                           */
/*==============================================================*/


alter table class
   drop constraint FK_CLASS_REFERENCE_GRADE;

alter table course
   drop constraint FK_COURSE_REFERENCE_CLASSER;

alter table grade
   drop constraint FK_GRADE_REFERENCE_MAJOR;

alter table results
   drop constraint FK_RESULTS_REFERENCE_COURSE;

alter table results
   drop constraint FK_RESULTS_REFERENCE_STUDENT;

alter table student
   drop constraint FK_STUDENT_REFERENCE_CLASS;

drop table class cascade constraints;

drop table classer cascade constraints;

drop table course cascade constraints;

drop table grade cascade constraints;

drop table major cascade constraints;

drop table results cascade constraints;

drop table student cascade constraints;

/*==============================================================*/
/* Table: class                                                 */
/*==============================================================*/
create table class 
(
   stu_class            VARCHAR2(30)         not null,
   stu_grade            VARCHAR2(30),
   constraint PK_CLASS primary key (stu_class)
);

/*==============================================================*/
/* Table: classer                                               */
/*==============================================================*/
create table classer 
(
   course_gene          VARCHAR2(30)         not null,
   constraint PK_CLASSER primary key (course_gene)
);

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course 
(
   course_id            VARCHAR2(30)         not null,
   course_gene          VARCHAR2(30),
   course_name          VARCHAR2(100),
   grade_value          VARCHAR2(10),
   constraint PK_COURSE primary key (course_id)
);

/*==============================================================*/
/* Table: grade                                                 */
/*==============================================================*/
create table grade 
(
   stu_grade            VARCHAR2(30)         not null,
   stu_major            VARCHAR2(64),
   constraint PK_GRADE primary key (stu_grade)
);

/*==============================================================*/
/* Table: major                                                 */
/*==============================================================*/
create table major 
(
   stu_major            VARCHAR2(64)         not null,
   constraint PK_MAJOR primary key (stu_major)
);

/*==============================================================*/
/* Table: results                                               */
/*==============================================================*/
create table results 
(
   grade_id             VARCHAR2(20)         not null,
   stu_id               VARCHAR2(30),
   course_id            VARCHAR2(30),
   course_num           VARCHAR2(20),
   term                 VARCHAR2(30),
   grade_us             VARCHAR2(10),
   grade_ex             VARCHAR2(10),
   grade_all            VARCHAR2(10),
   constraint PK_RESULTS primary key (grade_id)
);

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student 
(
   stu_id               VARCHAR2(30)         not null,
   stu_class            VARCHAR2(30),
   stu_name             VARCHAR2(30),
   constraint PK_STUDENT primary key (stu_id)
);

alter table class
   add constraint FK_CLASS_REFERENCE_GRADE foreign key (stu_grade)
      references grade (stu_grade);

alter table course
   add constraint FK_COURSE_REFERENCE_CLASSER foreign key (course_gene)
      references classer (course_gene);

alter table grade
   add constraint FK_GRADE_REFERENCE_MAJOR foreign key (stu_major)
      references major (stu_major);

alter table results
   add constraint FK_RESULTS_REFERENCE_COURSE foreign key (course_id)
      references course (course_id);

alter table results
   add constraint FK_RESULTS_REFERENCE_STUDENT foreign key (stu_id)
      references student (stu_id);

alter table student
   add constraint FK_STUDENT_REFERENCE_CLASS foreign key (stu_class)
      references class (stu_class);

