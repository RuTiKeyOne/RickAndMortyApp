package com.example.rickandmortyapp.network;

import com.example.rickandmortyapp.response.child.CharacterResponse;
import com.example.rickandmortyapp.response.child.LocationResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("character")
    Call<CharacterResponse> getCharacters(@Query("page") int page);

    @GET("location")
    Call<LocationResponse> getLocations(@Query("page") int page);
}
