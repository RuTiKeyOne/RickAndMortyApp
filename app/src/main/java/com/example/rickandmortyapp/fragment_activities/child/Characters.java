package com.example.rickandmortyapp.fragment_activities.child;

import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.base.BaseCommand;
import com.example.rickandmortyapp.fragment_activities.commandpattern.base.BaseActivityCommand;
import com.example.rickandmortyapp.fragment_activities.parent.BaseFragmentActivity;
import com.example.rickandmortyapp.models.characterdata.Character;
import com.example.rickandmortyapp.response.child.CharacterResponse;

public class Characters extends BaseFragmentActivity<Character> {

    public Characters(BaseActivityCommand baseActivityCommand, BaseCommand baseCommand,
                      int idLayout) {
        super(baseActivityCommand, baseCommand, idLayout, new CharacterResponse());
    }
}