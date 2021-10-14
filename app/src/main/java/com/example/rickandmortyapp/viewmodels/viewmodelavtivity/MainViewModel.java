package com.example.rickandmortyapp.viewmodels.viewmodelavtivity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.rickandmortyapp.repositories.CharactersRepository;
import com.example.rickandmortyapp.response.CharacterResponse;

public class MainViewModel extends ViewModel {
    public static final int LOCATION_FRAGMENT_KEY = 1;
    public static final int EPISODES_FRAGMENT_KEY = 2;
    public static final int TAB_LAYOUTS_COUNT = 3;

}
