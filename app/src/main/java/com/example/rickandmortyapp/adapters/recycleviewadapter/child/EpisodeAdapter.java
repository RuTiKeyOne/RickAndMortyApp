package com.example.rickandmortyapp.adapters.recycleviewadapter.child;

import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.base.BaseCommand;
import com.example.rickandmortyapp.adapters.recycleviewadapter.parent.DataAdapter;
import com.example.rickandmortyapp.models.characterdata.Character;
import com.example.rickandmortyapp.models.episodedata.Episode;

import java.util.List;

public class EpisodeAdapter  extends DataAdapter<Episode, Integer> {
    public EpisodeAdapter(List<Episode> data, BaseCommand command, Integer idLayout) {
        super(data, command, idLayout);
    }
}
