package com.example.rickandmortyapp.fragmentactivities.child;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rickandmortyapp.adapters.recycleviewadapter.child.CharactersAdapter;
import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.base.BaseCommand;
import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.child.LocationCommands;
import com.example.rickandmortyapp.databinding.LocationsFragmentBinding;
import com.example.rickandmortyapp.fragmentactivities.commandpattern.base.BaseActivityCommand;
import com.example.rickandmortyapp.fragmentactivities.parent.BaseFragmentActivity;
import com.example.rickandmortyapp.models.locationdata.Location;
import com.example.rickandmortyapp.response.child.LocationResponse;
import com.example.rickandmortyapp.response.parent.Response;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.LocationsViewModel;
import com.example.rickandmortyapp.R;

import java.util.ArrayList;

public class Locations extends BaseFragmentActivity<Location> {


    public Locations(BaseActivityCommand command, BaseCommand baseCommand, int idLayout) {
        super(command, baseCommand, idLayout, new LocationResponse());
    }
}