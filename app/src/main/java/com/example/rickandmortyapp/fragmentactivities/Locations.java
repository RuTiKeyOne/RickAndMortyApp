package com.example.rickandmortyapp.fragmentactivities;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rickandmortyapp.adapters.recycleviewadapter.child.CharactersAdapter;
import com.example.rickandmortyapp.databinding.CharactersFragmentBinding;
import com.example.rickandmortyapp.databinding.LocationsFragmentBinding;
import com.example.rickandmortyapp.response.child.LocationResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.CharactersViewModel;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.LocationsViewModel;
import com.example.rickandmortyapp.R;

public class Locations extends Fragment {

    private LocationsViewModel locationsViewModel;
    private LocationsFragmentBinding locationsBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        initializeComponentsView(inflater, container, savedInstanceState);
        getLocations();
        return setInitialView();
    }

    private View setInitialView(){
        View view = locationsBinding.getRoot();
        return view;
    }

    private void initializeComponentsView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                          @Nullable Bundle savedInstanceState) {
        locationsBinding = LocationsFragmentBinding.inflate(inflater, container, false);
        locationsViewModel = new ViewModelProvider(this).get(LocationsViewModel.class);
    }

    private void getLocations(){
        locationsViewModel.getDataByPage(1).observe(getViewLifecycleOwner(), locationResponse -> {
            Toast.makeText(getContext(), locationResponse.getInfo().getPages() + " ", Toast.LENGTH_LONG).show();
        });
    }

}