package com.example.mrqin.myapplication.model;

import java.io.Serializable;

/**
 * Created by Mrqin on 2018/3/16.
 */

public class MainUrlBean implements Serializable {

    /**
     * appid : 911580001
     * appname : 小亮安卓
     * isshowwap : 1
     * wapurl : https://apk.update-daquan369app.com/
     * status : 1
     * desc : 成功返回数据
     * 接口返回的为空 不做跳转
     */

    private String appid;
    private String appname;
    private String isshowwap;//是否跳转到wap页面，1：是 加载wapurl 2：否  不加载
    private String wapurl;// 0：否 不加载    wapurl  wap页面URL
    private int status;//1：成功，2：失败
    private String desc;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getIsshowwap() {
        return isshowwap;
    }

    public void setIsshowwap(String isshowwap) {
        this.isshowwap = isshowwap;
    }

    public String getWapurl() {
        return wapurl;
    }

    public void setWapurl(String wapurl) {
        this.wapurl = wapurl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
