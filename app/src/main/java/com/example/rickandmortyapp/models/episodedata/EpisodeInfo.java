package com.example.rickandmortyapp.models.episodedata;

import com.google.gson.annotations.SerializedName;

public class EpisodeInfo {

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
