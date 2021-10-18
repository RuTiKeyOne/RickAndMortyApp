package com.example.rickandmortyapp.activities.commandpatter.child;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.rickandmortyapp.activities.SearchActivity;
import com.example.rickandmortyapp.activities.child.Activity;
import com.example.rickandmortyapp.activities.commandpatter.parent.BaseIntentCommand;
import com.example.rickandmortyapp.models.locationdata.Location;
import com.example.rickandmortyapp.response.child.LocationResponse;
import com.example.rickandmortyapp.response.parent.Response;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.parent.BaseViewModel;

public class LocationIntentCommand extends BaseIntentCommand<Location> {

    public LocationIntentCommand(BaseViewModel viewModel, Activity activity, Response response) {
        super(viewModel, activity, response);
    }

    @Override
    public void getData() {
        viewModel.getDataByPage(startPage).observe(activity, response -> {
            data.addAll(((LocationResponse)response).getLocations());
        });
    }

    @Override
    public Intent executeCommandActivity(Context context) {
        Intent intent = new Intent(context.getApplicationContext(), SearchActivity.class);
        intent.putExtra(DATA_INTENT_KEY, getBundle());
        return intent;
    }
}
