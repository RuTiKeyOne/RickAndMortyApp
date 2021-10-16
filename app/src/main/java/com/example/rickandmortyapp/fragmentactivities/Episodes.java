package com.example.rickandmortyapp.fragmentactivities;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.EpisodesViewModel;
import com.example.rickandmortyapp.R;

public class Episodes extends Fragment {

    private EpisodesViewModel mViewModel;

    public static Episodes newInstance() {
        return new Episodes();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.episodes_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EpisodesViewModel.class);
        // TODO: Use the ViewModel
    }

}