package com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.child;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.base.BaseCommand;
import com.example.rickandmortyapp.databinding.ItemLocationContainerBinding;
import com.example.rickandmortyapp.models.locationdata.Location;

public class LocationCommand extends BaseCommand<Location> {
    @Override
    public void bindData(Location location, ViewDataBinding dataBinding) {
        ((ItemLocationContainerBinding) dataBinding).setLocation(location);
    }

    @Override
    public ViewDataBinding setItemContainerBinding(LayoutInflater layoutInflater, int idLayout, ViewGroup parent) {
        ItemLocationContainerBinding binding = DataBindingUtil.inflate(layoutInflater, idLayout, parent, false);
        return binding;
    }
}
