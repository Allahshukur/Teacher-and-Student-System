package com.company.entity;

import java.io.Serializable;

public class Store implements Serializable {

    private Student[] list;
    private Teacher[] listteacher;

    public Student[] getList() {
        return list;
    }

    public void setList(Student[] list) {
        this.list = list;
    }

    public Teacher[] getListteacher() {
        return listteacher;
    }

    public void setListteacher(Teacher[] listteacher) {
        this.listteacher = listteacher;
    }
}
