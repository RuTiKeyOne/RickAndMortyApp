package com.example.rickandmortyapp.repositories.child;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.rickandmortyapp.fragment_activities.child.Characters;
import com.example.rickandmortyapp.models.characterdata.Character;
import com.example.rickandmortyapp.models.characterdata.CharacterInfo;
import com.example.rickandmortyapp.repositories.parent.Repository;
import com.example.rickandmortyapp.response.child.CharacterResponse;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharactersRepository extends Repository<CharacterResponse> {

    @Override
    public LiveData<CharacterResponse> getDataByPage(int page) {
        MutableLiveData<CharacterResponse> data = new MutableLiveData<>();
        service.getCharacters(page).enqueue(new Callback<CharacterResponse>() {
            @Override
            public void onResponse(@NotNull Call<CharacterResponse> call, @NotNull Response<CharacterResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<CharacterResponse> call, @NotNull Throwable t) {
                getDataByPage(page);
            }
        });

        return data;
    }

}
