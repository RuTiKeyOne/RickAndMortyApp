package com.example.rickandmortyapp.viewmodels.viewmodelsfragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.rickandmortyapp.repositories.CharactersRepository;
import com.example.rickandmortyapp.response.CharacterResponse;

public class CharactersViewModel extends ViewModel {
    private CharactersRepository charactersRepository;

    public CharactersViewModel() {
        this.charactersRepository = new CharactersRepository();
    }

    public LiveData<CharacterResponse> getCharacters(int page){
        return charactersRepository.getCharacters(page);
    }
}