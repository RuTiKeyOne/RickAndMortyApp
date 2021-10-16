package com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child;
import com.example.rickandmortyapp.repositories.child.LocationsRepository;
import androidx.lifecycle.ViewModel;

import com.example.rickandmortyapp.response.child.LocationResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.parent.BaseViewModel;

public class LocationsViewModel extends BaseViewModel<LocationsRepository, LocationResponse> {
    public LocationsViewModel() {
        this.repository = new LocationsRepository();
    }
}