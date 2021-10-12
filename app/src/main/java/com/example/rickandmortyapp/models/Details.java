package com.example.rickandmortyapp.models;

import com.google.gson.annotations.SerializedName;

public class Details {
    @SerializedName("count")
    private String count;

    @SerializedName("pages")
    private String pages;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }
}
