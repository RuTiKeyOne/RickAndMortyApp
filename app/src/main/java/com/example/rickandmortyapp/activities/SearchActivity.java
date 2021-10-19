package com.example.rickandmortyapp.activities;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.activities.parent.Activity;
import com.example.rickandmortyapp.databinding.ActivitySearchBinding;

public class SearchActivity extends Activity {

    private ActivitySearchBinding searchBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeComponents();
    }

    private void initializeComponents() {
        searchBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        searchBinding.imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}