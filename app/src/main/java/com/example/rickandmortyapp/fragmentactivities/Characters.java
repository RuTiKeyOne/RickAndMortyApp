package com.example.rickandmortyapp.fragmentactivities;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rickandmortyapp.adapters.CharactersAdapter;
import com.example.rickandmortyapp.databinding.CharactersFragmentBinding;
import com.example.rickandmortyapp.models.Character;
import com.example.rickandmortyapp.repositories.CharactersRepository;
import com.example.rickandmortyapp.response.CharacterResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.CharactersViewModel;
import com.example.rickandmortyapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Characters extends Fragment {

    private CharactersViewModel charactersViewModel;
    private CharactersFragmentBinding charactersBinding;
    private List<Character> characters = new ArrayList<>();
    private CharactersAdapter adapter;

    public static Characters newInstance() {
        return new Characters();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        charactersBinding = CharactersFragmentBinding.inflate(inflater, container, false);
        View view = charactersBinding.getRoot();
        initializeComponentsView();
        getCharacters();
        return view;
    }


    private void initializeComponentsView() {
        charactersViewModel = new ViewModelProvider(this).get(CharactersViewModel.class);
        adapter = new CharactersAdapter(characters);
        charactersBinding.charactersRecycleView.setAdapter(adapter);
    }

    private void getCharacters(){
        charactersViewModel.getCharacters(1).observe(getViewLifecycleOwner(), characterResponse -> {
            characters.addAll(characterResponse.getCharacters());
            adapter.notifyDataSetChanged();
        });
    }


}