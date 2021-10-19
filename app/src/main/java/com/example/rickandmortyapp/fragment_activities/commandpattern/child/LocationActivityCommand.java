package com.example.rickandmortyapp.fragment_activities.commandpattern.child;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortyapp.adapters.recycleviewadapter.parent.DataAdapter;
import com.example.rickandmortyapp.databinding.LocationsFragmentBinding;
import com.example.rickandmortyapp.fragment_activities.commandpattern.base.BaseActivityCommand;
import com.example.rickandmortyapp.models.locationdata.Location;
import com.example.rickandmortyapp.repositories.child.LocationsRepository;
import com.example.rickandmortyapp.response.child.LocationResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelfragment.child.LocationsViewModel;
import com.example.rickandmortyapp.viewmodels.viewmodelfragment.parent.BaseViewModel;

import java.util.List;

public class LocationActivityCommand extends BaseActivityCommand<Location> {

    private LocationsViewModel viewModel;

    @Override
    public ViewDataBinding getFragmentBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return LocationsFragmentBinding.inflate(inflater, container, false);
    }

    @Override
    public List<Location> getData(Object response) {
        return ((LocationResponse)response).getLocations();
    }

    @Override
    public BaseViewModel<LocationsRepository, LocationResponse> getViewModel(Fragment fragment) {
        if(viewModel == null){
            viewModel = new ViewModelProvider(fragment).get(LocationsViewModel.class);
        }

        return viewModel;
    }

    @Override
    public ViewDataBinding setAdapter(ViewDataBinding viewDataBinding, DataAdapter adapter) {
        LocationsFragmentBinding locationsBinding = ((LocationsFragmentBinding)viewDataBinding);
        locationsBinding.locationsRecycleView.setAdapter(adapter);
        return locationsBinding;
    }

    @Override
    public Boolean getIsLoading(ViewDataBinding dataBinding) {
        LocationsFragmentBinding locationsBinding = ((LocationsFragmentBinding)dataBinding);
        return locationsBinding.getIsLoading();
    }

    @Override
    public Boolean getIsLoadingMore(ViewDataBinding dataBinding) {
        LocationsFragmentBinding locationsBinding = ((LocationsFragmentBinding)dataBinding);
        return locationsBinding.getIsLoadingMore();
    }

    @Override
    public ViewDataBinding setIsLoadingTrue(ViewDataBinding viewDataBinding) {
        LocationsFragmentBinding locationsBinding = ((LocationsFragmentBinding)viewDataBinding);
        locationsBinding.setIsLoading(true);
        return locationsBinding;
    }

    @Override
    public ViewDataBinding setIsLoadingFalse(ViewDataBinding viewDataBinding) {
        LocationsFragmentBinding locationsBinding = ((LocationsFragmentBinding)viewDataBinding);
        locationsBinding.setIsLoading(false);
        return locationsBinding;
    }

    @Override
    public ViewDataBinding setIsLoadingMoreTrue(ViewDataBinding viewDataBinding) {
        LocationsFragmentBinding locationsBinding = ((LocationsFragmentBinding)viewDataBinding);
        locationsBinding.setIsLoadingMore(true);
        return locationsBinding;
    }

    @Override
    public ViewDataBinding setIsLoadingMoreFalse(ViewDataBinding viewDataBinding) {
        LocationsFragmentBinding locationsBinding = ((LocationsFragmentBinding)viewDataBinding);
        locationsBinding.setIsLoadingMore(false);
        return locationsBinding;
    }

    @Override
    public void scrollNotifySender(ViewDataBinding viewDataBinding) {
        LocationsFragmentBinding locationsBinding = ((LocationsFragmentBinding)viewDataBinding);
        locationsBinding.locationsRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                scrollListener.notifyOnScrolled(!locationsBinding.locationsRecycleView.canScrollVertically(1));
            }
        });
    }

    @Override
    public int getTotalAvailablePages(Object response) {
        return ((LocationResponse)response).getInfo().getPages();
    }
}
