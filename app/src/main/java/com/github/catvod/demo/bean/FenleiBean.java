package com.github.catvod.demo.bean;

import java.util.List;

public class FenleiBean {

    /**
     * page : 1
     * pagecount : 2147483647
     * limit : 90
     * total : 2147483647
     * list : [{"vod_id":"https://www.finebv.com/tv/185789.html","vod_name":"仙武帝尊","vod_pic":"https://pic.fkpzw.com/img03/upload/vod/20220427-1/71c5590704ec32dc67916b0cef84c789.jpg","vod_remarks":"更新至278集"},{"vod_id":"https://www.finebv.com/tv/363242.html","vod_name":"穿越美人在作妖动态漫画第二季","vod_pic":"https://pic.fkpzw.com/img03/upload/vod/20231116-1/4bab47b2a5f8e0d4e80e8aa804e52feb.jpg","vod_remarks":"更新至3集"}]
     */

    private String page;
    private int pagecount;
    private int limit;
    private int total;
    private List<ListBean> list;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * vod_id : https://www.finebv.com/tv/185789.html
         * vod_name : 仙武帝尊
         * vod_pic : https://pic.fkpzw.com/img03/upload/vod/20220427-1/71c5590704ec32dc67916b0cef84c789.jpg
         * vod_remarks : 更新至278集
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
}
