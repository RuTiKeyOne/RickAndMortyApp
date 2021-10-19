package com.example.rickandmortyapp.activities.commandpatter.child;

import android.content.Context;
import android.content.Intent;

import com.example.rickandmortyapp.activities.SearchActivity;
import com.example.rickandmortyapp.activities.commandpatter.parent.BaseIntentCommand;
import com.example.rickandmortyapp.models.characterdata.Character;

public class CharacterIntentCommand extends BaseIntentCommand<Character> {



    @Override
    public Intent executeCommandActivity(Context context) {
        Intent intent = new Intent(context.getApplicationContext(), SearchActivity.class);
        return intent;
    }
}
