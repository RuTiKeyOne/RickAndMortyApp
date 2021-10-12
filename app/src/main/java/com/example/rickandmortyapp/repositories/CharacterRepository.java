package com.example.rickandmortyapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.rickandmortyapp.network.ApiClient;
import com.example.rickandmortyapp.network.ApiService;
import com.example.rickandmortyapp.responses.CharacterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterRepository {

    private ApiService service;

    public CharacterRepository() {
        service = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<CharacterResponse> getCharacters(){
        MutableLiveData<CharacterResponse> data = new MutableLiveData<>();
        service.getCharacters().enqueue(new Callback<CharacterResponse>() {
            @Override
            public void onResponse(Call<CharacterResponse> call, Response<CharacterResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CharacterResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
