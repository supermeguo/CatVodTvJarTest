package com.github.catvod.demo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class XshijueHomeListBean {

    /**
     * list : [{"vod_id":"361480","vod_name":"坚如磐石","vod_pic":"https://pic.fkpzw.com/img03/upload/vod/20231001-1/1cfb54a7289659847a40520a571a30e8.jpg","vod_remarks":""},{"vod_id":"361645","vod_name":"2023海峡两岸（漳州）中秋晚会","vod_pic":"https://pic.fkpzw.com/img03/upload/vod/20231007-1/d7dfcb10258e79e0b84a7b93fa0b9c17.jpg","vod_remarks":""}]
     * class : [{"type_id":"dianying","type_name":"电影"},{"type_id":"dianshiju","type_name":"电视剧"},{"type_id":"dongmna","type_name":"动漫"},{"type_id":"zongyi","type_name":"综艺"},{"type_id":"jilupian","type_name":"纪录片"}]
     * filters : {"dianying":[{"key":"cateId","name":"类型","value":[{"n":"全部","v":""},{"n":"科幻片","v":"khp"},{"n":"恐怖片","v":"kbp"},{"n":"爱情片","v":"aqp"},{"n":"剧情片","v":"jqp"},{"n":"奇幻片","v":"qhp"},{"n":"恐怖片","v":"kbp"},{"n":"剧情片","v":"jqp"}]},{"key":"area","name":"地区","value":[{"n":"全部","v":""},{"n":"大陆","v":"大陆"},{"n":"香港","v":"香港"},{"n":"台湾","v":"台湾"},{"n":"美国","v":"美国"},{"n":"法国","v":"法国"},{"n":"英国","v":"英国"},{"n":"日本","v":"日本"},{"n":"韩国","v":"韩国"},{"n":"德国","v":"德国"},{"n":"泰国","v":"泰国"},{"n":"印度","v":"印度"},{"n":"意大利","v":"意大利"},{"n":"西班牙","v":"西班牙"},{"n":"加拿大","v":"加拿大"}]},{"key":"year","name":"年份","value":[{"n":"全部","v":""},{"n":"2023","v":"2023"},{"n":"2022","v":"2022"},{"n":"2021","v":"2021"},{"n":"2020","v":"2020"},{"n":"2019","v":"2019"},{"n":"2018","v":"2018"},{"n":"2017","v":"2017"},{"n":"2016","v":"2016"},{"n":"2015","v":"2015"},{"n":"2014","v":"2014"},{"n":"2013","v":"2013"},{"n":"2012","v":"2012"},{"n":"2011","v":"2011"},{"n":"2010","v":"2010"}]}],"dianshiju":[{"key":"cateId","name":"类型","value":[{"n":"全部","v":""},{"n":"国产剧","v":"gcj"},{"n":"港台剧","v":"gtj"},{"n":"日韩剧","v":"rhj"},{"n":"海外剧","v":"hwj"}]},{"key":"area","name":"地区","value":[{"n":"全部","v":""},{"n":"大陆","v":"大陆"},{"n":"香港","v":"香港"},{"n":"台湾","v":"台湾"},{"n":"美国","v":"美国"},{"n":"法国","v":"法国"},{"n":"英国","v":"英国"},{"n":"日本","v":"日本"},{"n":"韩国","v":"韩国"},{"n":"德国","v":"德国"},{"n":"泰国","v":"泰国"},{"n":"印度","v":"印度"},{"n":"意大利","v":"意大利"},{"n":"西班牙","v":"西班牙"},{"n":"加拿大","v":"加拿大"}]},{"key":"year","name":"年份","value":[{"n":"全部","v":""},{"n":"2023","v":"2023"},{"n":"2022","v":"2022"},{"n":"2021","v":"2021"},{"n":"2020","v":"2020"},{"n":"2019","v":"2019"},{"n":"2018","v":"2018"},{"n":"2017","v":"2017"},{"n":"2016","v":"2016"},{"n":"2015","v":"2015"},{"n":"2014","v":"2014"},{"n":"2013","v":"2013"},{"n":"2012","v":"2012"},{"n":"2011","v":"2011"},{"n":"2010","v":"2010"},{"n":"2009","v":"2009"},{"n":"2008","v":"2008"},{"n":"2006","v":"2006"},{"n":"2005","v":"2005"},{"n":"2004","v":"2004"}]}],"zongyi":[{"key":"area","name":"地区","value":[{"n":"全部","v":""},{"n":"大陆","v":"大陆"},{"n":"香港","v":"香港"},{"n":"台湾","v":"台湾"},{"n":"美国","v":"美国"},{"n":"法国","v":"法国"},{"n":"英国","v":"英国"},{"n":"日本","v":"日本"},{"n":"韩国","v":"韩国"},{"n":"德国","v":"德国"},{"n":"泰国","v":"泰国"},{"n":"印度","v":"印度"},{"n":"意大利","v":"意大利"},{"n":"西班牙","v":"西班牙"},{"n":"加拿大","v":"加拿大"}]},{"key":"year","name":"年份","value":[{"n":"全部","v":""},{"n":"2023","v":"2023"},{"n":"2022","v":"2022"},{"n":"2021","v":"2021"},{"n":"2020","v":"2020"},{"n":"2019","v":"2019"},{"n":"2018","v":"2018"},{"n":"2017","v":"2017"},{"n":"2016","v":"2016"},{"n":"2015","v":"2015"},{"n":"2014","v":"2014"},{"n":"2013","v":"2013"},{"n":"2012","v":"2012"}]}],"dongmna":[{"key":"area","name":"地区","value":[{"n":"全部","v":""},{"n":"大陆","v":"大陆"},{"n":"香港","v":"香港"},{"n":"台湾","v":"台湾"},{"n":"美国","v":"美国"},{"n":"法国","v":"法国"},{"n":"英国","v":"英国"},{"n":"日本","v":"日本"},{"n":"韩国","v":"韩国"},{"n":"德国","v":"德国"},{"n":"泰国","v":"泰国"},{"n":"印度","v":"印度"},{"n":"意大利","v":"意大利"},{"n":"西班牙","v":"西班牙"},{"n":"加拿大","v":"加拿大"}]},{"key":"year","name":"年份","value":[{"n":"全部","v":""},{"n":"2023","v":"2023"},{"n":"2022","v":"2022"},{"n":"2021","v":"2021"},{"n":"2020","v":"2020"},{"n":"2019","v":"2019"},{"n":"2018","v":"2018"},{"n":"2017","v":"2017"},{"n":"2016","v":"2016"},{"n":"2015","v":"2015"},{"n":"2014","v":"2014"},{"n":"2013","v":"2013"},{"n":"2012","v":"2012"}]}],"jilupian":[{"key":"area","name":"地区","value":[{"n":"全部","v":""},{"n":"大陆","v":"大陆"},{"n":"香港","v":"香港"},{"n":"台湾","v":"台湾"},{"n":"美国","v":"美国"},{"n":"法国","v":"法国"},{"n":"英国","v":"英国"},{"n":"日本","v":"日本"},{"n":"韩国","v":"韩国"},{"n":"德国","v":"德国"},{"n":"泰国","v":"泰国"},{"n":"印度","v":"印度"},{"n":"意大利","v":"意大利"},{"n":"西班牙","v":"西班牙"},{"n":"加拿大","v":"加拿大"}]},{"key":"year","name":"年份","value":[{"n":"全部","v":""},{"n":"2023","v":"2023"},{"n":"2022","v":"2022"},{"n":"2021","v":"2021"},{"n":"2020","v":"2020"},{"n":"2019","v":"2019"},{"n":"2018","v":"2018"},{"n":"2017","v":"2017"},{"n":"2016","v":"2016"},{"n":"2015","v":"2015"},{"n":"2014","v":"2014"},{"n":"2013","v":"2013"},{"n":"2012","v":"2012"}]}]}
     */

    private FiltersBean filters;
    private List<ListBean> list;
    @SerializedName("class")
    private List<ClassBean> classX;

    public FiltersBean getFilters() {
        return filters;
    }

    public void setFilters(FiltersBean filters) {
        this.filters = filters;
    }

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

    public static class FiltersBean {
        private List<DianyingBean> dianying;
        private List<DianshijuBean> dianshiju;
        private List<ZongyiBean> zongyi;
        private List<DongmnaBean> dongmna;
        private List<JilupianBean> jilupian;

        public List<DianyingBean> getDianying() {
            return dianying;
        }

        public void setDianying(List<DianyingBean> dianying) {
            this.dianying = dianying;
        }

        public List<DianshijuBean> getDianshiju() {
            return dianshiju;
        }

        public void setDianshiju(List<DianshijuBean> dianshiju) {
            this.dianshiju = dianshiju;
        }

        public List<ZongyiBean> getZongyi() {
            return zongyi;
        }

        public void setZongyi(List<ZongyiBean> zongyi) {
            this.zongyi = zongyi;
        }

        public List<DongmnaBean> getDongmna() {
            return dongmna;
        }

        public void setDongmna(List<DongmnaBean> dongmna) {
            this.dongmna = dongmna;
        }

        public List<JilupianBean> getJilupian() {
            return jilupian;
        }

        public void setJilupian(List<JilupianBean> jilupian) {
            this.jilupian = jilupian;
        }

        public static class DianyingBean {
            /**
             * key : cateId
             * name : 类型
             * value : [{"n":"全部","v":""},{"n":"科幻片","v":"khp"},{"n":"恐怖片","v":"kbp"},{"n":"爱情片","v":"aqp"},{"n":"剧情片","v":"jqp"},{"n":"奇幻片","v":"qhp"},{"n":"恐怖片","v":"kbp"},{"n":"剧情片","v":"jqp"}]
             */

            private String key;
            private String name;
            private List<ValueBean> value;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<ValueBean> getValue() {
                return value;
            }

            public void setValue(List<ValueBean> value) {
                this.value = value;
            }

            public static class ValueBean {
                /**
                 * n : 全部
                 * v :
                 */

                private String n;
                private String v;

                public String getN() {
                    return n;
                }

                public void setN(String n) {
                    this.n = n;
                }

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }
            }
        }

        public static class DianshijuBean {
            /**
             * key : cateId
             * name : 类型
             * value : [{"n":"全部","v":""},{"n":"国产剧","v":"gcj"},{"n":"港台剧","v":"gtj"},{"n":"日韩剧","v":"rhj"},{"n":"海外剧","v":"hwj"}]
             */

            private String key;
            private String name;
            private List<ValueBeanX> value;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<ValueBeanX> getValue() {
                return value;
            }

            public void setValue(List<ValueBeanX> value) {
                this.value = value;
            }

            public static class ValueBeanX {
                /**
                 * n : 全部
                 * v :
                 */

                private String n;
                private String v;

                public String getN() {
                    return n;
                }

                public void setN(String n) {
                    this.n = n;
                }

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }
            }
        }

        public static class ZongyiBean {
            /**
             * key : area
             * name : 地区
             * value : [{"n":"全部","v":""},{"n":"大陆","v":"大陆"},{"n":"香港","v":"香港"},{"n":"台湾","v":"台湾"},{"n":"美国","v":"美国"},{"n":"法国","v":"法国"},{"n":"英国","v":"英国"},{"n":"日本","v":"日本"},{"n":"韩国","v":"韩国"},{"n":"德国","v":"德国"},{"n":"泰国","v":"泰国"},{"n":"印度","v":"印度"},{"n":"意大利","v":"意大利"},{"n":"西班牙","v":"西班牙"},{"n":"加拿大","v":"加拿大"}]
             */

            private String key;
            private String name;
            private List<ValueBeanXX> value;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<ValueBeanXX> getValue() {
                return value;
            }

            public void setValue(List<ValueBeanXX> value) {
                this.value = value;
            }

            public static class ValueBeanXX {
                /**
                 * n : 全部
                 * v :
                 */

                private String n;
                private String v;

                public String getN() {
                    return n;
                }

                public void setN(String n) {
                    this.n = n;
                }

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }
            }
        }

        public static class DongmnaBean {
            /**
             * key : area
             * name : 地区
             * value : [{"n":"全部","v":""},{"n":"大陆","v":"大陆"},{"n":"香港","v":"香港"},{"n":"台湾","v":"台湾"},{"n":"美国","v":"美国"},{"n":"法国","v":"法国"},{"n":"英国","v":"英国"},{"n":"日本","v":"日本"},{"n":"韩国","v":"韩国"},{"n":"德国","v":"德国"},{"n":"泰国","v":"泰国"},{"n":"印度","v":"印度"},{"n":"意大利","v":"意大利"},{"n":"西班牙","v":"西班牙"},{"n":"加拿大","v":"加拿大"}]
             */

            private String key;
            private String name;
            private List<ValueBeanXXX> value;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<ValueBeanXXX> getValue() {
                return value;
            }

            public void setValue(List<ValueBeanXXX> value) {
                this.value = value;
            }

            public static class ValueBeanXXX {
                /**
                 * n : 全部
                 * v :
                 */

                private String n;
                private String v;

                public String getN() {
                    return n;
                }

                public void setN(String n) {
                    this.n = n;
                }

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }
            }
        }

        public static class JilupianBean {
            /**
             * key : area
             * name : 地区
             * value : [{"n":"全部","v":""},{"n":"大陆","v":"大陆"},{"n":"香港","v":"香港"},{"n":"台湾","v":"台湾"},{"n":"美国","v":"美国"},{"n":"法国","v":"法国"},{"n":"英国","v":"英国"},{"n":"日本","v":"日本"},{"n":"韩国","v":"韩国"},{"n":"德国","v":"德国"},{"n":"泰国","v":"泰国"},{"n":"印度","v":"印度"},{"n":"意大利","v":"意大利"},{"n":"西班牙","v":"西班牙"},{"n":"加拿大","v":"加拿大"}]
             */

            private String key;
            private String name;
            private List<ValueBeanXXXX> value;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<ValueBeanXXXX> getValue() {
                return value;
            }

            public void setValue(List<ValueBeanXXXX> value) {
                this.value = value;
            }

            public static class ValueBeanXXXX {
                /**
                 * n : 全部
                 * v :
                 */

                private String n;
                private String v;

                public String getN() {
                    return n;
                }

                public void setN(String n) {
                    this.n = n;
                }

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }
            }
        }
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
