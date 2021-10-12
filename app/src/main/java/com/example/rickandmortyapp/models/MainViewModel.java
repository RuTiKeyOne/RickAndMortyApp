package com.example.rickandmortyapp.models;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private static final int TAB_LAYOUTS_COUNT = 3;

    public static int getTabLayoutsCount() {
        return TAB_LAYOUTS_COUNT;
    }
}
