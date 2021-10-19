package com.example.rickandmortyapp.activities.commandpatter.child;

import android.content.Context;
import android.content.Intent;

import com.example.rickandmortyapp.activities.child.searchactivities.child.SearchLocationActivity;
import com.example.rickandmortyapp.activities.child.searchactivities.parent.SearchActivity;
import com.example.rickandmortyapp.activities.commandpatter.parent.BaseIntentCommand;
import com.example.rickandmortyapp.models.locationdata.Location;

public class LocationIntentCommand extends BaseIntentCommand<Location> {




    @Override
    public Intent executeCommandActivity(Context context) {
        Intent intent = new Intent(context.getApplicationContext(), SearchLocationActivity.class);
        return intent;
    }
}
