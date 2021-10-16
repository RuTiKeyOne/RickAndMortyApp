package com.example.rickandmortyapp.response.child;

import com.example.rickandmortyapp.models.locationdata.Location;
import com.example.rickandmortyapp.models.locationdata.LocationInfo;
import com.example.rickandmortyapp.response.parent.Response;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LocationResponse extends Response {
    @SerializedName("info")
    private LocationInfo info;

    @SerializedName("results")
    private List<Location> locations;

    public LocationInfo getInfo() {
        return info;
    }

    public List<Location> getLocations() {
        return locations;
    }
}
