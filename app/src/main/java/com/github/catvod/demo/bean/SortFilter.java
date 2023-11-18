package com.github.catvod.demo.bean;

import java.util.LinkedHashMap;

public  class SortFilter {
    public String key;
    public String name;
    public LinkedHashMap<String, String> values;

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

    public LinkedHashMap<String, String> getValues() {
        return values;
    }

    public void setValues(LinkedHashMap<String, String> values) {
        this.values = values;
    }
}