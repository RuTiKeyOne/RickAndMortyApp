package com.example.rickandmortyapp.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.child.CharacterCommands;
import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.child.EpisodeCommands;
import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.child.LocationCommands;
import com.example.rickandmortyapp.fragmentactivities.child.Characters;
import com.example.rickandmortyapp.fragmentactivities.child.Episodes;
import com.example.rickandmortyapp.fragmentactivities.child.Locations;
import com.example.rickandmortyapp.fragmentactivities.commandpattern.child.CharacterActivityCommand;
import com.example.rickandmortyapp.fragmentactivities.commandpattern.child.EpisodeActivityCommand;
import com.example.rickandmortyapp.fragmentactivities.commandpattern.child.LocationActivityCommand;
import com.example.rickandmortyapp.models.characterdata.Character;
import com.example.rickandmortyapp.viewmodels.viewmodelavtivity.MainViewModel;

public class FragmentAdapter extends FragmentStateAdapter {

    private Characters characters;

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position) {
            case MainViewModel.LOCATION_FRAGMENT_KEY:
                return new Locations(new LocationActivityCommand(), new LocationCommands(), R.layout.item_location_container);
            case MainViewModel.EPISODES_FRAGMENT_KEY:
                return new Episodes(new EpisodeActivityCommand(), new EpisodeCommands(), R.layout.item_episode_container);
        }

        return new Characters(new CharacterActivityCommand(), new CharacterCommands(), R.layout.item_character_container);
    }

    @Override
    public int getItemCount() {
        return MainViewModel.TAB_LAYOUTS_COUNT;
    }
}
