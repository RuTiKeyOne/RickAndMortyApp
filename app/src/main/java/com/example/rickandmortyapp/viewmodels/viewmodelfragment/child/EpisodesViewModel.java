package com.example.rickandmortyapp.viewmodels.viewmodelfragment.child;

import com.example.rickandmortyapp.repositories.child.EpisodesRepository;
import com.example.rickandmortyapp.response.child.EpisodeResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelfragment.parent.BaseViewModel;

public class EpisodesViewModel extends BaseViewModel<EpisodesRepository, EpisodeResponse> {
    public EpisodesViewModel() {
        this.repository = new EpisodesRepository();
    }
}