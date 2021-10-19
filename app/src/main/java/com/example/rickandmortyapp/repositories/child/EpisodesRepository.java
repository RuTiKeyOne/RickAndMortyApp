package com.example.rickandmortyapp.repositories.child;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.rickandmortyapp.models.episodedata.Episode;
import com.example.rickandmortyapp.models.episodedata.EpisodeInfo;
import com.example.rickandmortyapp.repositories.parent.Repository;
import com.example.rickandmortyapp.response.child.EpisodeResponse;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodesRepository extends Repository<EpisodeResponse> {

    @Override
    public LiveData<EpisodeResponse> getDataByPage(int page) {
        MutableLiveData<EpisodeResponse> data = new MutableLiveData<>();
        service.getEpisodes(page).enqueue(new Callback<EpisodeResponse>() {
            @Override
            public void onResponse(@NotNull Call<EpisodeResponse> call, @NotNull Response<EpisodeResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<EpisodeResponse> call,@NotNull Throwable t) {
                throw new NullPointerException();
            }
        });

        return data;
    }

}
