package com.github.catvod.demo.bean;

import java.util.List;

public class DetailBean {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * vod_id : 361480
         * vod_name : 坚如磐石
         * vod_pic : https://pic.fkpzw.com/img03/upload/vod/20231001-1/1cfb54a7289659847a40520a571a30e8.jpg
         * type_name : 动作片
         * vod_year : 2023
         * vod_area : 中国大陆
         * vod_remarks :
         * vod_actor : 雷佳音
         * vod_director : 张艺谋
         * vod_content : 金江市副市长郑刚（张国立 饰）之子苏见明（雷佳音 饰）不顾父亲的劝阻，应邀赴约首富黎志田（于和伟 饰）的“鸿门宴”，不料却被迫观看了一出“人手下火锅”的猖狂戏码。旧案翻起，风雨欲来，各方蛰伏势力蠢蠢欲动，筹谋与算计、审视与怀疑，光怪陆离之中，人性欲望翻腾，谁将撕去最后的面具？
         * vod_play_from : 新视觉影视①$$$新视觉影视②
         * vod_play_url : TC正片$361480_2_1$$$坚如P石$361480_1_1
         */

        private String vod_id;
        private String vod_name;
        private String vod_pic;
        private String type_name;
        private String vod_year;
        private String vod_area;
        private String vod_remarks;
        private String vod_actor;
        private String vod_director;
        private String vod_content;
        private String vod_play_from;
        private String vod_play_url;

        public String getVod_id() {
            return vod_id;
        }

        public void setVod_id(String vod_id) {
            this.vod_id = vod_id;
        }

        public String getVod_name() {
            return vod_name;
        }

        public void setVod_name(String vod_name) {
            this.vod_name = vod_name;
        }

        public String getVod_pic() {
            return vod_pic;
        }

        public void setVod_pic(String vod_pic) {
            this.vod_pic = vod_pic;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

        public String getVod_year() {
            return vod_year;
        }

        public void setVod_year(String vod_year) {
            this.vod_year = vod_year;
        }

        public String getVod_area() {
            return vod_area;
        }

        public void setVod_area(String vod_area) {
            this.vod_area = vod_area;
        }

        public String getVod_remarks() {
            return vod_remarks;
        }

        public void setVod_remarks(String vod_remarks) {
            this.vod_remarks = vod_remarks;
        }

        public String getVod_actor() {
            return vod_actor;
        }

        public void setVod_actor(String vod_actor) {
            this.vod_actor = vod_actor;
        }

        public String getVod_director() {
            return vod_director;
        }

        public void setVod_director(String vod_director) {
            this.vod_director = vod_director;
        }

        public String getVod_content() {
            return vod_content;
        }

        public void setVod_content(String vod_content) {
            this.vod_content = vod_content;
        }

        public String getVod_play_from() {
            return vod_play_from;
        }

        public void setVod_play_from(String vod_play_from) {
            this.vod_play_from = vod_play_from;
        }

        public String getVod_play_url() {
            return vod_play_url;
        }

        public void setVod_play_url(String vod_play_url) {
            this.vod_play_url = vod_play_url;
        }
    }
}
