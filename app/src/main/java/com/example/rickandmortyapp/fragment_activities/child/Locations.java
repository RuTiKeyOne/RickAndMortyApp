package com.example.rickandmortyapp.fragment_activities.child;

import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.base.BaseCommand;
import com.example.rickandmortyapp.fragment_activities.commandpattern.base.BaseActivityCommand;
import com.example.rickandmortyapp.fragment_activities.parent.BaseFragmentActivity;
import com.example.rickandmortyapp.models.locationdata.Location;
import com.example.rickandmortyapp.response.child.LocationResponse;

public class Locations extends BaseFragmentActivity<Location> {


    public Locations(BaseActivityCommand baseActivityCommand, BaseCommand baseCommand,
                     int idLayout) {
        super(baseActivityCommand, baseCommand, idLayout, new LocationResponse());
    }
}