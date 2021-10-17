package com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.child;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.base.BaseCommand;
import com.example.rickandmortyapp.databinding.ItemCharacterContainerBinding;
import com.example.rickandmortyapp.databinding.ItemEpisodeContainerBinding;
import com.example.rickandmortyapp.databinding.ItemLocationContainerBinding;
import com.example.rickandmortyapp.models.episodedata.Episode;

public class EpisodeCommands extends BaseCommand<Episode> {
    @Override
    public void bindData(Episode data, ViewDataBinding dataBinding) {
        ((ItemEpisodeContainerBinding)dataBinding).setEpisode(data);
    }

    @Override
    public ViewDataBinding setItemContainerBinding(LayoutInflater layoutInflater, int idLayout, ViewGroup parent) {
        ItemEpisodeContainerBinding binding = DataBindingUtil.inflate(layoutInflater, idLayout, parent, false);
        return binding;
    }
}
