package com.example.rickandmortyapp.models.locationdata;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Location implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;

    @SerializedName("dimension")
    private String dimension;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDimension() {
        return dimension;
    }
}
