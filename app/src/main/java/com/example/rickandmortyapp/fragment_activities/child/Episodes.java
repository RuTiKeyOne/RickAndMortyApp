package com.example.rickandmortyapp.fragment_activities.child;

import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.base.BaseCommand;
import com.example.rickandmortyapp.fragment_activities.commandpattern.base.BaseActivityCommand;
import com.example.rickandmortyapp.fragment_activities.parent.BaseFragmentActivity;
import com.example.rickandmortyapp.response.child.EpisodeResponse;

public class Episodes extends BaseFragmentActivity<Episodes> {
    public Episodes(BaseActivityCommand baseActivityCommand, BaseCommand baseCommand,
                    int idLayout) {
        super(baseActivityCommand, baseCommand, idLayout, new EpisodeResponse());
    }
}