package com.example.rickandmortyapp.activities.child.searchactivities.parent;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.activities.parent.Activity;
import com.example.rickandmortyapp.databinding.ActivitySearchBinding;

public abstract class SearchActivity extends Activity {

    protected ActivitySearchBinding searchBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeComponents();
        getData();
    }

    public abstract void getData();

    protected void initializeComponents() {
        searchBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        searchBinding.imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}