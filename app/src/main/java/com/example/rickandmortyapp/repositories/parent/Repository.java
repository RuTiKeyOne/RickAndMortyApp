package com.example.rickandmortyapp.repositories.parent;

import android.content.Intent;

import androidx.lifecycle.LiveData;

import com.example.rickandmortyapp.network.ApiClient;
import com.example.rickandmortyapp.network.ApiService;

public abstract class Repository<T> {

    protected ApiService service;

    public Repository() {
        service = ApiClient.getRetrofit().create(ApiService.class);
    }

    public abstract LiveData<T> getDataByPage(int page);


}
