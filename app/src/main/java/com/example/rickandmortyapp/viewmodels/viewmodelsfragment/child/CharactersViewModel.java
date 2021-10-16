package com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.rickandmortyapp.repositories.child.CharactersRepository;
import com.example.rickandmortyapp.response.child.CharacterResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.parent.BaseViewModel;

public class CharactersViewModel extends BaseViewModel<CharactersRepository, CharacterResponse> {
    public CharactersViewModel() {
        this.repository = new CharactersRepository();
    }
}