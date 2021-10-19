package com.example.rickandmortyapp.viewmodels.viewmodelfragment.child;

import com.example.rickandmortyapp.repositories.child.CharactersRepository;
import com.example.rickandmortyapp.response.child.CharacterResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelfragment.parent.BaseViewModel;

public class CharactersViewModel extends BaseViewModel<CharactersRepository, CharacterResponse> {
    public CharactersViewModel() {
        this.repository = new CharactersRepository();
    }
}