package com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child;

import androidx.lifecycle.ViewModel;

import com.example.rickandmortyapp.repositories.child.CharactersRepository;
import com.example.rickandmortyapp.repositories.child.EpisodesRepository;
import com.example.rickandmortyapp.response.child.CharacterResponse;
import com.example.rickandmortyapp.response.child.EpisodeResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.parent.BaseViewModel;

public class EpisodesViewModel extends BaseViewModel<EpisodesRepository, EpisodeResponse> {
    public EpisodesViewModel() {
        this.repository = new EpisodesRepository();
    }
}