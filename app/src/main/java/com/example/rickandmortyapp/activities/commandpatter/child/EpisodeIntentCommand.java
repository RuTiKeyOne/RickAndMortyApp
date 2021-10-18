package com.example.rickandmortyapp.activities.commandpatter.child;

import android.content.Context;
import android.content.Intent;

import com.example.rickandmortyapp.activities.SearchActivity;
import com.example.rickandmortyapp.activities.child.Activity;
import com.example.rickandmortyapp.activities.commandpatter.parent.BaseIntentCommand;
import com.example.rickandmortyapp.models.episodedata.Episode;
import com.example.rickandmortyapp.response.child.EpisodeResponse;
import com.example.rickandmortyapp.response.parent.Response;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.parent.BaseViewModel;

public class EpisodeIntentCommand extends BaseIntentCommand<Episode> {

    public EpisodeIntentCommand(BaseViewModel viewModel, Activity activity, Response response) {
        super(viewModel, activity, response);
    }



    @Override
    public void getData() {
        viewModel.getDataByPage(startPage).observe(activity, response -> {
            data.addAll(((EpisodeResponse)response).getEpisodes());
        });
    }

    @Override
    public Intent executeCommandActivity(Context context) {
        Intent intent = new Intent(context.getApplicationContext(), SearchActivity.class);
        return intent;
    }
}
