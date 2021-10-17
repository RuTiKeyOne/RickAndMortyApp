package com.example.rickandmortyapp.fragmentactivities.child;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.base.BaseCommand;
import com.example.rickandmortyapp.fragmentactivities.commandpattern.base.BaseActivityCommand;
import com.example.rickandmortyapp.fragmentactivities.parent.BaseFragmentActivity;
import com.example.rickandmortyapp.response.child.EpisodeResponse;
import com.example.rickandmortyapp.response.parent.Response;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.EpisodesViewModel;
import com.example.rickandmortyapp.R;

public class Episodes extends BaseFragmentActivity<Episodes> {
    public Episodes(BaseActivityCommand command, BaseCommand baseCommand, int idLayout) {
        super(command, baseCommand, idLayout, new EpisodeResponse());
    }
}