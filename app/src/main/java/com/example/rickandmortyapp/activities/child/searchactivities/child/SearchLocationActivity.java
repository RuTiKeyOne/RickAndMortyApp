package com.example.rickandmortyapp.activities.child.searchactivities.child;

import androidx.lifecycle.ViewModelProvider;

import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.activities.child.searchactivities.parent.SearchActivity;
import com.example.rickandmortyapp.adapters.recycleviewadapter.child.CharactersAdapter;
import com.example.rickandmortyapp.adapters.recycleviewadapter.child.LocationAdapter;
import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.child.CharacterCommands;
import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.child.LocationCommands;
import com.example.rickandmortyapp.response.child.LocationResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.CharactersViewModel;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.LocationsViewModel;

public class SearchLocationActivity extends SearchActivity {
    @Override
    public void getData() {
        viewModel.getDataByPage(1).observe(this, locationResponse -> {
            data.addAll(((LocationResponse)locationResponse).getLocations());
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public void initializeComponents() {
        super.initializeComponents();
        this.adapter = new LocationAdapter(data, new LocationCommands(), R.layout.item_location_container);
        viewModel = new ViewModelProvider(this).get(LocationsViewModel.class);
    }
}
