package com.example.rickandmortyapp.activities.child.searchactivities.parent;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.activities.parent.Activity;
import com.example.rickandmortyapp.adapters.recycleviewadapter.child.CharactersAdapter;
import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.base.BaseCommand;
import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.child.CharacterCommands;
import com.example.rickandmortyapp.adapters.recycleviewadapter.parent.DataAdapter;
import com.example.rickandmortyapp.databinding.ActivitySearchBinding;
import com.example.rickandmortyapp.models.characterdata.Character;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.CharactersViewModel;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.parent.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

public abstract class SearchActivity<Data> extends Activity {

    protected ActivitySearchBinding searchBinding;
    protected DataAdapter adapter;
    protected List<Data> data = new ArrayList<>();
    protected BaseViewModel viewModel;

    protected int idLayout;
    protected BaseCommand baseCommand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeComponents();
        initializeComponentsView();
        getData();
    }

    public abstract void getData();

    public void initializeComponents(){
        this.baseCommand = baseCommand;
        this.idLayout = idLayout;
        searchBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);
    }

    protected void initializeComponentsView() {
        searchBinding.imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        searchBinding.mainRecycleView.setAdapter(adapter);
    }
}