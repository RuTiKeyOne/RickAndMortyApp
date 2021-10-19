package com.example.rickandmortyapp.repositories.child;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.rickandmortyapp.repositories.parent.Repository;
import com.example.rickandmortyapp.response.child.LocationResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationsRepository extends Repository<LocationResponse> {



    @Override
    public LiveData<LocationResponse> getDataByPage(int page) {
        MutableLiveData<LocationResponse> data = new MutableLiveData<>();
        service.getLocations(page).enqueue(new Callback<LocationResponse>() {

            @Override
            public void onResponse(@NotNull Call<LocationResponse> call,@NotNull Response<LocationResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<LocationResponse> call,@NotNull Throwable t) {
                throw new NullPointerException();
            }
        });

        return data;
    }
}