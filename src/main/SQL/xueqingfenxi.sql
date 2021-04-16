/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2021/4/16 21:04:17                           */
/*==============================================================*/


alter table class
   drop constraint FK_CLASS_REFERENCE_GRADE;

alter table classer
   drop constraint FK_CLASSER_REFERENCE_MAJOR;

alter table course
   drop constraint FK_COURSE_REFERENCE_CLASSER;

alter table credits
   drop constraint FK_CREDITS_REFERENCE_RESULTS;

alter table credits
   drop constraint FK_CREDITS_REFERENCE_COURSE;

alter table grade
   drop constraint FK_GRADE_REFERENCE_MAJOR;

alter table results
   drop constraint FK_RESULTS_REFERENCE_STUDENT;

alter table results
   drop constraint FK_RESULTS_REFERENCE_COURSE;

alter table student
   drop constraint FK_STUDENT_REFERENCE_CLASS;

drop table class cascade constraints;

drop table classer cascade constraints;

drop table course cascade constraints;

drop table credits cascade constraints;

drop table grade cascade constraints;

drop table major cascade constraints;

drop table results cascade constraints;

drop table student cascade constraints;

/*==============================================================*/
/* Table: class                                                 */
/*==============================================================*/
create table class 
(
   class_ID             NUMBER(8)            not null,
   grade_ID             NUMBER(8),
   class_Grade          NUMBER(8),
   constraint PK_CLASS primary key (class_ID)
);

/*==============================================================*/
/* Table: classer                                               */
/*==============================================================*/
create table classer 
(
   classer_ID           NUMBER(8)            not null,
   major_Name           VARCHAR(32),
   classer_Name         VARCHAR2(32),
   constraint PK_CLASSER primary key (classer_ID)
);

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course 
(
   course_ID            NUMBER(8)            not null,
   classer_ID           NUMBER(8),
   course_Name          VARCHAR2(32),
   course_Credits       NUMBER(2),
   constraint PK_COURSE primary key (course_ID)
);

/*==============================================================*/
/* Table: credits                                               */
/*==============================================================*/
create table credits 
(
   stu_ID               NUMBER(10)           not null,
   course_ID            NUMBER(8),
   credits_True         NUMBER(2),
   course_Credits       NUMBER(2),
   constraint PK_CREDITS primary key (stu_ID)
);

/*==============================================================*/
/* Table: grade                                                 */
/*==============================================================*/
create table grade 
(
   grade_ID             NUMBER(8)            not null,
   major_Name           VARCHAR(32),
   constraint PK_GRADE primary key (grade_ID)
);

/*==============================================================*/
/* Table: major                                                 */
/*==============================================================*/
create table major 
(
   major_Name           VARCHAR(32)          not null,
   constraint PK_MAJOR primary key (major_Name)
);

/*==============================================================*/
/* Table: results                                               */
/*==============================================================*/
create table results 
(
   stu_ID               NUMBER(10)           not null,
   course_ID            NUMBER(8),
   results              NUMBER(3),
   constraint PK_RESULTS primary key (stu_ID)
);

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student 
(
   stu_ID               NUMBER(10)           not null,
   stu_Name             VARCHAR2(32),
   class_ID             NUMBER(8),
   constraint PK_STUDENT primary key (stu_ID)
);

alter table class
   add constraint FK_CLASS_REFERENCE_GRADE foreign key (grade_ID)
      references grade (grade_ID);

alter table classer
   add constraint FK_CLASSER_REFERENCE_MAJOR foreign key (major_Name)
      references major (major_Name);

alter table course
   add constraint FK_COURSE_REFERENCE_CLASSER foreign key (classer_ID)
      references classer (classer_ID);

alter table credits
   add constraint FK_CREDITS_REFERENCE_RESULTS foreign key (stu_ID)
      references results (stu_ID);

alter table credits
   add constraint FK_CREDITS_REFERENCE_COURSE foreign key (course_ID)
      references course (course_ID);

alter table grade
   add constraint FK_GRADE_REFERENCE_MAJOR foreign key (major_Name)
      references major (major_Name);

alter table results
   add constraint FK_RESULTS_REFERENCE_STUDENT foreign key (stu_ID)
      references student (stu_ID);

alter table results
   add constraint FK_RESULTS_REFERENCE_COURSE foreign key (course_ID)
      references course (course_ID);

alter table student
   add constraint FK_STUDENT_REFERENCE_CLASS foreign key (class_ID)
      references class (class_ID);

