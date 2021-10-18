package com.example.rickandmortyapp.activities;

import android.os.Bundle;

import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.activities.child.Activity;

public class SearchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
}