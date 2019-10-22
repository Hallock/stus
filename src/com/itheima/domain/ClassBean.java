package com.itheima.domain;

public class ClassBean {
    private int cid;
    private String sno;
    private String class_name;
    private String class_teacher;
    private String class_test;
    private int class_result;

    public int getCid() {
        return cid;
    }

    public String getSno() {
        return sno;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getClass_teacher() {
        return class_teacher;
    }

    public String getClass_test() {
        return class_test;
    }

    public int getClass_result() {
        return class_result;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public void setClass_teacher(String class_teacher) {
        this.class_teacher = class_teacher;
    }

    public void setClass_test(String class_test) {
        this.class_test = class_test;
    }

    public void setClass_result(int class_result) {
        this.class_result = class_result;
    }
}
