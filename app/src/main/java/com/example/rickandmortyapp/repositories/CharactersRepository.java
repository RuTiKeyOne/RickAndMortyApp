package com.example.rickandmortyapp.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.rickandmortyapp.network.ApiClient;
import com.example.rickandmortyapp.network.ApiService;
import com.example.rickandmortyapp.response.CharacterResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharactersRepository {
    private ApiService service;

    public CharactersRepository() {
        service = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<CharacterResponse> getCharacters(int page){
        MutableLiveData<CharacterResponse> data = new MutableLiveData<>();
        service.getCharacters(page).enqueue(new Callback<CharacterResponse>() {
            @Override
            public void onResponse(@NotNull Call<CharacterResponse> call,@NotNull Response<CharacterResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<CharacterResponse> call,@NotNull Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}
