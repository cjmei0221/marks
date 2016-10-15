package com.cjmei.module.teacher.pojo;

import java.io.Serializable;
import java.util.Date;

public class Teacher implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *老师ID
    */
    private String teacherId;
    /**
    *老师姓名
    */
    private String teacherName;



    public String getTeacherId(){
        return teacherId;
    }
    public void setTeacherId(String teacherId){
        this.teacherId = teacherId;
    }

    public String getTeacherName(){
        return teacherName;
    }
    public void setTeacherName(String teacherName){
        this.teacherName = teacherName;
    }


}