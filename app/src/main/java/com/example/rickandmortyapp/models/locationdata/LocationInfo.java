package com.example.rickandmortyapp.models.locationdata;

import com.google.gson.annotations.SerializedName;

public class LocationInfo {

    @SerializedName("count")
    private int count;

    @SerializedName("pages")
    private int pages;

    public int getCount() {
        return count;
    }

    public int getPages() {
        return pages;
    }
}
