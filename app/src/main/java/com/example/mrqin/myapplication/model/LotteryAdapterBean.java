package com.example.mrqin.myapplication.model;

import java.io.Serializable;

/**
 * Created by Mrqin on 2018/3/14.
 */

public class LotteryAdapterBean implements Serializable{

    private String title;
    private String num;
    private String time;
    private String code;
    private String name;

    public LotteryAdapterBean() {
    }

    public LotteryAdapterBean(String title, String num, String time, String code, String name) {
        this.title = title;
        this.num = num;
        this.time = time;
        this.code = code;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
