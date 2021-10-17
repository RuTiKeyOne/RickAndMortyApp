package com.example.rickandmortyapp.adapters.recycleviewadapter.child;

import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.base.BaseCommand;
import com.example.rickandmortyapp.adapters.recycleviewadapter.parent.DataAdapter;
import com.example.rickandmortyapp.models.characterdata.Character;

import java.util.List;

public class CharactersAdapter<T> extends DataAdapter<Character, Integer> {

    public CharactersAdapter(List<Character> data, BaseCommand command, int idLayout) {
        super(data, command, idLayout);
    }
}
