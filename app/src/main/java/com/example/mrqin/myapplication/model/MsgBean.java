package com.example.mrqin.myapplication.model;

/**
 * @data on 2018/3/15 9:59
 * @describe: 机器人发消息
 */

public class MsgBean {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SEND = 1;

    private String content;
    private int type;

    public MsgBean(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
