package com.example.rickandmortyapp.models.episodedata;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Episode implements Serializable {

    @SerializedName("episode")
    private String episode;

    @SerializedName("air_date")
    private String air_date;

    @SerializedName("name")
    private String name;

    public String getEpisode() {
        return episode;
    }

    public String getAir_date() {
        return air_date;
    }

    public String getName() {
        return name;
    }
}
