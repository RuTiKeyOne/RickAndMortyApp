package com.example.rickandmortyapp.adapters.recycleviewadapter.child;

import com.example.rickandmortyapp.adapters.recycleviewadapter.command.base.BaseCommand;
import com.example.rickandmortyapp.adapters.recycleviewadapter.parent.DataAdapter;
import com.example.rickandmortyapp.models.locationdata.Location;

import java.util.List;

public class LocationAdapter extends DataAdapter<Location, Integer> {
    public LocationAdapter(List<Location> data, BaseCommand command, Integer idLayout) {
        super(data, command, idLayout);
    }
}
