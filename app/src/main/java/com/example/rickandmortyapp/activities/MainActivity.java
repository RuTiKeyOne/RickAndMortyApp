package com.example.rickandmortyapp.activities;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.activities.commandpatter.child.CharacterIntentCommand;
import com.example.rickandmortyapp.activities.commandpatter.child.EpisodeIntentCommand;
import com.example.rickandmortyapp.activities.commandpatter.child.LocationIntentCommand;
import com.example.rickandmortyapp.activities.commandpatter.parent.BaseIntentCommand;
import com.example.rickandmortyapp.activities.parent.Activity;
import com.example.rickandmortyapp.adapters.FragmentAdapter;
import com.example.rickandmortyapp.databinding.ActivityMainBinding;
import com.example.rickandmortyapp.viewmodels.viewmodelavtivity.MainViewModel;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends Activity {

    private ActivityMainBinding mainBinding;
    private FragmentAdapter adapter;
    private MainViewModel mainViewModel;
    private BaseIntentCommand intentCommand;
    private BaseIntentCommand[] intentCommands;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeComponents();
        setTabLayout();
        setIntentAction();
    }

    private void initializeComponents(){
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        intentCommands = new BaseIntentCommand[]
                {   new CharacterIntentCommand(),
                    new LocationIntentCommand(),
                    new EpisodeIntentCommand()
                };
        intentCommand = intentCommands[0];

    }

    private void setTabLayout(){
        adapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
        mainBinding.mainViewPager.setAdapter(adapter);
        mainBinding.mainTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mainBinding.mainViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
        mainBinding.mainViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                mainBinding.mainTabLayout.selectTab(mainBinding.mainTabLayout.getTabAt(position));
                changeSearchCommand(intentCommands[position]);
            }
        });

    }

    private void setIntentAction(){
        mainBinding.imageSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentCommand.executeCommandActivity(getApplicationContext()));
            }
        });
    }

    private void changeSearchCommand(BaseIntentCommand command){
        intentCommand = command;
    }

}