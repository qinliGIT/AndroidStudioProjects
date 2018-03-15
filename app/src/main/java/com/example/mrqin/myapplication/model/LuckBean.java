package com.example.mrqin.myapplication.model;

import java.io.Serializable;

/**
 * Created by Mrqin on 2018/3/15.
 */

public class LuckBean implements Serializable{

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"day":{"day_notice":"异性缘佳，吃喝玩乐的机会多。","general_txt":"有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。","grxz":"双鱼座","love_star":4,"love_txt":"会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。","lucky_direction":"西北方","lucky_num":"3","lucky_time_color":"上午6:00--8:00浅莲红","money_star":2,"money_txt":"财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。","summary_star":3,"time":"20160113","work_star":3,"work_txt":"只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。"},"tomorrow":{"day_notice":"异性缘佳，吃喝玩乐的机会多。","general_txt":"有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。","grxz":"双鱼座","love_star":4,"love_txt":"会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。","lucky_direction":"西北方","lucky_num":"3","lucky_time_color":"上午6:00--8:00浅莲红","money_star":2,"money_txt":"财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。","summary_star":3,"time":"20160113","work_star":3,"work_txt":"只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。"},"week":{"day_notice":"异性缘佳，吃喝玩乐的机会多。","general_txt":"有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。","grxz":"双鱼座","love_star":4,"love_txt":"会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。","lucky_direction":"西北方","lucky_num":"3","lucky_time_color":"上午6:00--8:00浅莲红","money_star":2,"money_txt":"财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。","summary_star":3,"time":"20160113","work_star":3,"work_txt":"只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。"},"month":{"day_notice":"异性缘佳，吃喝玩乐的机会多。","general_txt":"有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。","grxz":"双鱼座","love_star":4,"love_txt":"会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。","lucky_direction":"西北方","lucky_num":"3","lucky_time_color":"上午6:00--8:00浅莲红","money_star":2,"money_txt":"财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。","summary_star":3,"time":"20160113","work_star":3,"work_txt":"只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。"},"year":{"day_notice":"异性缘佳，吃喝玩乐的机会多。","general_txt":"有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。","grxz":"双鱼座","love_star":4,"love_txt":"会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。","lucky_direction":"西北方","lucky_num":"3","lucky_time_color":"上午6:00--8:00浅莲红","money_star":2,"money_txt":"财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。","summary_star":3,"time":"20160113","work_star":3,"work_txt":"只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。"},"star":"shizi"}
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
         * day : {"day_notice":"异性缘佳，吃喝玩乐的机会多。","general_txt":"有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。","grxz":"双鱼座","love_star":4,"love_txt":"会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。","lucky_direction":"西北方","lucky_num":"3","lucky_time_color":"上午6:00--8:00浅莲红","money_star":2,"money_txt":"财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。","summary_star":3,"time":"20160113","work_star":3,"work_txt":"只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。"}
         * tomorrow : {"day_notice":"异性缘佳，吃喝玩乐的机会多。","general_txt":"有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。","grxz":"双鱼座","love_star":4,"love_txt":"会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。","lucky_direction":"西北方","lucky_num":"3","lucky_time_color":"上午6:00--8:00浅莲红","money_star":2,"money_txt":"财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。","summary_star":3,"time":"20160113","work_star":3,"work_txt":"只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。"}
         * week : {"day_notice":"异性缘佳，吃喝玩乐的机会多。","general_txt":"有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。","grxz":"双鱼座","love_star":4,"love_txt":"会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。","lucky_direction":"西北方","lucky_num":"3","lucky_time_color":"上午6:00--8:00浅莲红","money_star":2,"money_txt":"财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。","summary_star":3,"time":"20160113","work_star":3,"work_txt":"只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。"}
         * month : {"day_notice":"异性缘佳，吃喝玩乐的机会多。","general_txt":"有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。","grxz":"双鱼座","love_star":4,"love_txt":"会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。","lucky_direction":"西北方","lucky_num":"3","lucky_time_color":"上午6:00--8:00浅莲红","money_star":2,"money_txt":"财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。","summary_star":3,"time":"20160113","work_star":3,"work_txt":"只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。"}
         * year : {"day_notice":"异性缘佳，吃喝玩乐的机会多。","general_txt":"有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。","grxz":"双鱼座","love_star":4,"love_txt":"会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。","lucky_direction":"西北方","lucky_num":"3","lucky_time_color":"上午6:00--8:00浅莲红","money_star":2,"money_txt":"财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。","summary_star":3,"time":"20160113","work_star":3,"work_txt":"只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。"}
         * star : shizi
         */

        private DayBean day;
        private TomorrowBean tomorrow;
        private WeekBean week;
        private MonthBean month;
        private YearBean year;
        private String star;

        public DayBean getDay() {
            return day;
        }

        public void setDay(DayBean day) {
            this.day = day;
        }

        public TomorrowBean getTomorrow() {
            return tomorrow;
        }

        public void setTomorrow(TomorrowBean tomorrow) {
            this.tomorrow = tomorrow;
        }

        public WeekBean getWeek() {
            return week;
        }

        public void setWeek(WeekBean week) {
            this.week = week;
        }

        public MonthBean getMonth() {
            return month;
        }

        public void setMonth(MonthBean month) {
            this.month = month;
        }

        public YearBean getYear() {
            return year;
        }

        public void setYear(YearBean year) {
            this.year = year;
        }

        public String getStar() {
            return star;
        }

        public void setStar(String star) {
            this.star = star;
        }

        public static class DayBean {
            /**
             * day_notice : 异性缘佳，吃喝玩乐的机会多。
             * general_txt : 有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。
             * grxz : 双鱼座
             * love_star : 4
             * love_txt : 会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。
             * lucky_direction : 西北方
             * lucky_num : 3
             * lucky_time_color : 上午6:00--8:00浅莲红
             * money_star : 2
             * money_txt : 财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。
             * summary_star : 3
             * time : 20160113
             * work_star : 3
             * work_txt : 只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。
             */

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

        public static class TomorrowBean {
            /**
             * day_notice : 异性缘佳，吃喝玩乐的机会多。
             * general_txt : 有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。
             * grxz : 双鱼座
             * love_star : 4
             * love_txt : 会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。
             * lucky_direction : 西北方
             * lucky_num : 3
             * lucky_time_color : 上午6:00--8:00浅莲红
             * money_star : 2
             * money_txt : 财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。
             * summary_star : 3
             * time : 20160113
             * work_star : 3
             * work_txt : 只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。
             */

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

        public static class WeekBean {
            /**
             * day_notice : 异性缘佳，吃喝玩乐的机会多。
             * general_txt : 有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。
             * grxz : 双鱼座
             * love_star : 4
             * love_txt : 会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。
             * lucky_direction : 西北方
             * lucky_num : 3
             * lucky_time_color : 上午6:00--8:00浅莲红
             * money_star : 2
             * money_txt : 财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。
             * summary_star : 3
             * time : 20160113
             * work_star : 3
             * work_txt : 只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。
             */

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

        public static class MonthBean {
            /**
             * day_notice : 异性缘佳，吃喝玩乐的机会多。
             * general_txt : 有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。
             * grxz : 双鱼座
             * love_star : 4
             * love_txt : 会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。
             * lucky_direction : 西北方
             * lucky_num : 3
             * lucky_time_color : 上午6:00--8:00浅莲红
             * money_star : 2
             * money_txt : 财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。
             * summary_star : 3
             * time : 20160113
             * work_star : 3
             * work_txt : 只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。
             */

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

        public static class YearBean {
            /**
             * day_notice : 异性缘佳，吃喝玩乐的机会多。
             * general_txt : 有许多异性朋友主动邀约，特别是晚上，在闲聊中与异性朋友产生情愫。工作没有太大的压力，出现失误也易得到上司的谅解，若能积极一些会有更大的收获。今天不宜急于投资，适合观望。
             * grxz : 双鱼座
             * love_star : 4
             * love_txt : 会有异性主动靠近，让你有些受宠若惊。单身者想恋爱，但仍停留在观望阶段。
             * lucky_direction : 西北方
             * lucky_num : 3
             * lucky_time_color : 上午6:00--8:00浅莲红
             * money_star : 2
             * money_txt : 财务是今日的生活重心，虽然运气有点不稳定，外力干扰多了点，可是只要保守谨慎些，不会有太大的问题。
             * summary_star : 3
             * time : 20160113
             * work_star : 3
             * work_txt : 只要用心的对待工作，注意和拍档之间的交流与合作，手头的任务会很顺利的进行。
             */

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
    }
}
