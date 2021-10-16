package com.example.rickandmortyapp.repositories.parent;

import androidx.lifecycle.LiveData;

import com.example.rickandmortyapp.network.ApiClient;
import com.example.rickandmortyapp.network.ApiService;
import com.example.rickandmortyapp.response.child.CharacterResponse;

public abstract class Repository<T> {

    protected ApiService service;

    public Repository() {
        service = ApiClient.getRetrofit().create(ApiService.class);
    }

    public abstract LiveData<T> getDataByPage(int page);

}
