package com.example.rickandmortyapp.fragmentactivities;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rickandmortyapp.adapters.recycleviewadapter.child.CharactersAdapter;
import com.example.rickandmortyapp.adapters.recycleviewadapter.command.child.LocationCommand;
import com.example.rickandmortyapp.databinding.CharactersFragmentBinding;
import com.example.rickandmortyapp.databinding.LocationsFragmentBinding;
import com.example.rickandmortyapp.models.locationdata.Location;
import com.example.rickandmortyapp.response.child.LocationResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.CharactersViewModel;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.LocationsViewModel;
import com.example.rickandmortyapp.R;

import java.util.ArrayList;
import java.util.List;

public class Locations extends Fragment {

    private LocationsViewModel locationsViewModel;
    private LocationsFragmentBinding locationsBinding;
    private ArrayList<Location> locations = new ArrayList<>();
    private CharactersAdapter adapter;
    private int currentPage = 1;
    private int totalAvailablePages = 1;

    public static Locations newInstance() {
        return new Locations();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        initializeComponentsView(inflater, container, savedInstanceState);
        ScrollRecycleViewManager();
        getLocations();
        return setInitialView();
    }

    private View setInitialView() {
        View view = locationsBinding.getRoot();
        return view;
    }

    private void initializeComponentsView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                          @Nullable Bundle savedInstanceState) {
        locationsBinding = LocationsFragmentBinding.inflate(inflater, container, false);
        locationsViewModel = new ViewModelProvider(this).get(LocationsViewModel.class);
        adapter = new CharactersAdapter(locations, new LocationCommand(), R.layout.item_location_container);
        locationsBinding.locationsRecycleView.setAdapter(adapter);


    }

    private void getLocations() {
        toggleLoadingManager();
        locationsViewModel.getDataByPage(currentPage).observe(getViewLifecycleOwner(), locationResponse -> {
            if(locationResponse != null){
                totalAvailablePages = locationResponse.getInfo().getPages();
                locations.addAll(locationResponse.getLocations());
                adapter.notifyDataSetChanged();
            }
            toggleLoadingManager();
        });
    }

    private void toggleLoadingManager() {
        if (currentPage == 1) {
            toggleStartLoading();
        } else {
            toggleMoreLoading();
        }
    }

    private void toggleStartLoading() {
        if (locationsBinding.getIsLoading() != null && locationsBinding.getIsLoading()) {
            locationsBinding.setIsLoading(false);
        } else {
            locationsBinding.setIsLoading(true);
        }
    }

    private void toggleMoreLoading() {
        if (locationsBinding.getIsLoadingMore() != null && locationsBinding.getIsLoadingMore()) {
            locationsBinding.setIsLoadingMore(false);
        } else {
            locationsBinding.setIsLoadingMore(true);
        }
    }

    private void ScrollRecycleViewManager() {
        locationsBinding.locationsRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (!locationsBinding.locationsRecycleView.canScrollVertically(1) && currentPage <= totalAvailablePages) {
                    currentPage += 1;
                    getLocations();
                }
            }
        });
    }

}