package com.example.rickandmortyapp.network;

import com.example.rickandmortyapp.responses.CharacterResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("character")
    Call<CharacterResponse> getCharacters();

}
