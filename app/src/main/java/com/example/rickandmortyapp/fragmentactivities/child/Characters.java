package com.example.rickandmortyapp.fragmentactivities.child;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.adapters.recycleviewadapter.child.CharactersAdapter;
import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.base.BaseCommand;
import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.child.CharacterCommands;
import com.example.rickandmortyapp.databinding.CharactersFragmentBinding;
import com.example.rickandmortyapp.fragmentactivities.commandpattern.base.BaseActivityCommand;
import com.example.rickandmortyapp.fragmentactivities.parent.BaseFragmentActivity;
import com.example.rickandmortyapp.models.characterdata.Character;
import com.example.rickandmortyapp.response.child.CharacterResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.CharactersViewModel;

import java.util.ArrayList;
import java.util.List;

public class Characters extends BaseFragmentActivity<Character> {

    public Characters(BaseActivityCommand command, BaseCommand baseCommand, int idLayout) {
        super(command, baseCommand, idLayout, new CharacterResponse());
    }
}