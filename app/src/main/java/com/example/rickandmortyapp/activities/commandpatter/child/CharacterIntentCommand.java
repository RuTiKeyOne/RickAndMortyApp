package com.example.rickandmortyapp.activities.commandpatter.child;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.rickandmortyapp.activities.SearchActivity;
import com.example.rickandmortyapp.activities.child.Activity;
import com.example.rickandmortyapp.activities.commandpatter.parent.BaseIntentCommand;
import com.example.rickandmortyapp.models.characterdata.Character;
import com.example.rickandmortyapp.response.child.CharacterResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.CharactersViewModel;

public class CharacterIntentCommand extends BaseIntentCommand<Character> {

    public CharacterIntentCommand(CharactersViewModel viewModel, Activity activity, CharacterResponse response) {
        super(viewModel, activity, response);
    }

    @Override
    public void getData() {
        viewModel.getDataByPage(startPage).observe(activity, response -> {
            data.addAll(((CharacterResponse)response).getCharacters());
        });
    }

    @Override
    public Intent executeCommandActivity(Context context) {
        Intent intent = new Intent(context.getApplicationContext(), SearchActivity.class);
        intent.putExtra(DATA_INTENT_KEY, getBundle());
        return intent;
    }
}
