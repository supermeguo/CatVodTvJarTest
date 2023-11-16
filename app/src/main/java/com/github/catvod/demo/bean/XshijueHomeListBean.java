package com.github.catvod.demo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class XshijueHomeListBean {

    private List<ListBean> list;
    @SerializedName("class")
    private List<ClassBean> classX;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public List<ClassBean> getClassX() {
        return classX;
    }

    public void setClassX(List<ClassBean> classX) {
        this.classX = classX;
    }

    public static class ListBean {
        /**
         * vod_id : 361480
         * vod_name : 坚如磐石
         * vod_pic : https://pic.fkpzw.com/img03/upload/vod/20231001-1/1cfb54a7289659847a40520a571a30e8.jpg
         * vod_remarks :
         */

        private String vod_id;
        private String vod_name;
        private String vod_pic;
        private String vod_remarks;

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

        public String getVod_remarks() {
            return vod_remarks;
        }

        public void setVod_remarks(String vod_remarks) {
            this.vod_remarks = vod_remarks;
        }
    }

    public static class ClassBean {
        /**
         * type_id : dianying
         * type_name : 电影
         */

        private String type_id;
        private String type_name;

        public String getType_id() {
            return type_id;
        }

        public void setType_id(String type_id) {
            this.type_id = type_id;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }
    }
}
