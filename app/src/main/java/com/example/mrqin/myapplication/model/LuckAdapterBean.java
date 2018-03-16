package com.example.mrqin.myapplication.model;

import java.io.Serializable;

/**
 * Created by Mrqin on 2018/3/16.
 */

public class LuckAdapterBean implements Serializable {
    private String day_notice;
    private String general_txt;
    private String grxz;
    private int love_star;
    private String love_txt;
    private String lucky_direction;
    private String lucky_num;
    private String lucky_time_color;
    private int money_star;
    private String money_txt;
    private int summary_star;
    private String time;
    private int work_star;
    private String work_txt;

    public LuckAdapterBean() {
    }

    public LuckAdapterBean(String day_notice, String general_txt, String grxz, int love_star, String love_txt, String lucky_direction, String lucky_num, String lucky_time_color, int money_star, String money_txt, int summary_star, String time, int work_star, String work_txt) {
        this.day_notice = day_notice;
        this.general_txt = general_txt;
        this.grxz = grxz;
        this.love_star = love_star;
        this.love_txt = love_txt;
        this.lucky_direction = lucky_direction;
        this.lucky_num = lucky_num;
        this.lucky_time_color = lucky_time_color;
        this.money_star = money_star;
        this.money_txt = money_txt;
        this.summary_star = summary_star;
        this.time = time;
        this.work_star = work_star;
        this.work_txt = work_txt;
    }

    public String getDay_notice() {
        return day_notice;
    }

    public void setDay_notice(String day_notice) {
        this.day_notice = day_notice;
    }

    public String getGeneral_txt() {
        return general_txt;
    }

    public void setGeneral_txt(String general_txt) {
        this.general_txt = general_txt;
    }

    public String getGrxz() {
        return grxz;
    }

    public void setGrxz(String grxz) {
        this.grxz = grxz;
    }

    public int getLove_star() {
        return love_star;
    }

    public void setLove_star(int love_star) {
        this.love_star = love_star;
    }

    public String getLove_txt() {
        return love_txt;
    }

    public void setLove_txt(String love_txt) {
        this.love_txt = love_txt;
    }

    public String getLucky_direction() {
        return lucky_direction;
    }

    public void setLucky_direction(String lucky_direction) {
        this.lucky_direction = lucky_direction;
    }

    public String getLucky_num() {
        return lucky_num;
    }

    public void setLucky_num(String lucky_num) {
        this.lucky_num = lucky_num;
    }

    public String getLucky_time_color() {
        return lucky_time_color;
    }

    public void setLucky_time_color(String lucky_time_color) {
        this.lucky_time_color = lucky_time_color;
    }

    public int getMoney_star() {
        return money_star;
    }

    public void setMoney_star(int money_star) {
        this.money_star = money_star;
    }

    public String getMoney_txt() {
        return money_txt;
    }

    public void setMoney_txt(String money_txt) {
        this.money_txt = money_txt;
    }

    public int getSummary_star() {
        return summary_star;
    }

    public void setSummary_star(int summary_star) {
        this.summary_star = summary_star;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getWork_star() {
        return work_star;
    }

    public void setWork_star(int work_star) {
        this.work_star = work_star;
    }

    public String getWork_txt() {
        return work_txt;
    }

    public void setWork_txt(String work_txt) {
        this.work_txt = work_txt;
    }
}
