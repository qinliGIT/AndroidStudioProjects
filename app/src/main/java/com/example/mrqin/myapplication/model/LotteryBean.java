package com.example.mrqin.myapplication.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mrqin on 2018/3/10.
 */

public class LotteryBean implements Serializable{

    /** 开奖
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"result":[{"code":"ssq","expect":"2015085","name":"双色球","openCode":"02,08,25,27,28,29+05","time":"2015-07-23 21:21:40","timestamp":1437657700000}],"ret_code":0}
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
         * result : [{"code":"ssq","expect":"2015085","name":"双色球","openCode":"02,08,25,27,28,29+05","time":"2015-07-23 21:21:40","timestamp":1437657700000}]
         * ret_code : 0
         */

        private int ret_code;
        private List<ResultBean> result;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * code : ssq
             * expect : 2015085
             * name : 双色球
             * openCode : 02,08,25,27,28,29+05
             * time : 2015-07-23 21:21:40
             * timestamp : 1437657700000
             */

            private String code;
            private String expect;
            private String name;
            private String openCode;
            private String time;
            private long timestamp;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getExpect() {
                return expect;
            }

            public void setExpect(String expect) {
                this.expect = expect;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getOpenCode() {
                return openCode;
            }

            public void setOpenCode(String openCode) {
                this.openCode = openCode;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public long getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(long timestamp) {
                this.timestamp = timestamp;
            }
        }
    }
}
