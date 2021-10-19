package com.example.rickandmortyapp.viewmodels.viewmodelfragment.child;
import com.example.rickandmortyapp.repositories.child.LocationsRepository;

import com.example.rickandmortyapp.response.child.LocationResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelfragment.parent.BaseViewModel;

public class LocationsViewModel extends BaseViewModel<LocationsRepository, LocationResponse> {
    public LocationsViewModel() {
        this.repository = new LocationsRepository();
    }
}