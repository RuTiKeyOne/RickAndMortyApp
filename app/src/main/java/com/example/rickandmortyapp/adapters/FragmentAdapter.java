package com.example.rickandmortyapp.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.rickandmortyapp.fragmentactivities.Characters;
import com.example.rickandmortyapp.fragmentactivities.Episodes;
import com.example.rickandmortyapp.fragmentactivities.Locations;
import com.example.rickandmortyapp.viewmodels.viewmodelavtivity.MainViewModel;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position) {
            case MainViewModel.LOCATION_FRAGMENT_KEY:
                return new Locations();
            case MainViewModel.EPISODES_FRAGMENT_KEY:
                return new Episodes();
        }

        return new Characters();
    }

    @Override
    public int getItemCount() {
        return MainViewModel.TAB_LAYOUTS_COUNT;
    }
}
