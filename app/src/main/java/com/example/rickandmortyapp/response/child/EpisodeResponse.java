package com.example.rickandmortyapp.response.child;

import com.example.rickandmortyapp.models.episodedata.Episode;
import com.example.rickandmortyapp.models.episodedata.EpisodeInfo;
import com.example.rickandmortyapp.response.parent.Response;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EpisodeResponse extends Response {

    @SerializedName("info")
    private EpisodeInfo info;

    @SerializedName("results")
    private List<Episode> episodes;

    public EpisodeInfo getInfo() {
        return info;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }
}
