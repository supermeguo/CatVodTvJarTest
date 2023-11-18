package com.github.catvod.demo.bean;

import java.util.ArrayList;

public class FiltersBean {
    public ArrayList<SortFilter> filters = new ArrayList<>();

    public ArrayList<SortFilter> getFilters() {
        return filters;
    }

    public void setFilters(ArrayList<SortFilter> filters) {
        this.filters = filters;
    }
}
