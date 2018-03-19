package com.example.mrqin.myapplication.model;

import java.io.Serializable;

/**
 * @data on 2018/3/15 18:07
 * @describe:
 */

public class RobotBean implements Serializable {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"code":100000,"ret_code":0,"text":"我叫图灵机器人，聪明又可爱的图灵机器人"}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * code : 100000
         * ret_code : 0
         * text : 我叫图灵机器人，聪明又可爱的图灵机器人
         */

        private int code;
        private int ret_code;
        private String text;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
