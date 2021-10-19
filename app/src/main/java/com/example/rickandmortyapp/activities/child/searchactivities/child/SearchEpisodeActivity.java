package com.example.rickandmortyapp.activities.child.searchactivities.child;

import androidx.lifecycle.ViewModelProvider;

import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.activities.child.searchactivities.parent.SearchActivity;
import com.example.rickandmortyapp.adapters.recycleviewadapter.child.CharactersAdapter;
import com.example.rickandmortyapp.adapters.recycleviewadapter.child.EpisodeAdapter;
import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.child.CharacterCommands;
import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.child.EpisodeCommands;
import com.example.rickandmortyapp.models.episodedata.Episode;
import com.example.rickandmortyapp.response.child.CharacterResponse;
import com.example.rickandmortyapp.response.child.EpisodeResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.CharactersViewModel;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.EpisodesViewModel;

public class SearchEpisodeActivity extends SearchActivity {
    @Override
    public void getData() {
        viewModel.getDataByPage(1).observe(this, episodeResponse -> {
            data.addAll(((EpisodeResponse)episodeResponse).getEpisodes());
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public void initializeComponents() {
        super.initializeComponents();
        this.adapter = new EpisodeAdapter(data, new EpisodeCommands(), R.layout.item_episode_container);
        viewModel = new ViewModelProvider(this).get(EpisodesViewModel.class);
    }
}
