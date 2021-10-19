package com.example.rickandmortyapp.activities.child.searchactivities.child;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.activities.child.searchactivities.parent.SearchActivity;
import com.example.rickandmortyapp.adapters.recycleviewadapter.child.CharactersAdapter;
import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.child.CharacterCommands;
import com.example.rickandmortyapp.models.characterdata.Character;
import com.example.rickandmortyapp.response.child.CharacterResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.CharactersViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchCharacterActivity extends SearchActivity<Character> {

    @Override
    public void getData() {
        viewModel.getDataByPage(1).observe(this, characterResponse -> {
            data.addAll(((CharacterResponse)characterResponse).getCharacters());
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public void initializeComponents() {
        super.initializeComponents();
        this.adapter = new CharactersAdapter(data, new CharacterCommands(), R.layout.item_character_container);
        viewModel = new ViewModelProvider(this).get(CharactersViewModel.class);
    }
}
