package com.example.rickandmortyapp.fragmentactivities.commandpattern.child;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortyapp.adapters.recycleviewadapter.parent.DataAdapter;
import com.example.rickandmortyapp.databinding.EpisodesFragmentBinding;
import com.example.rickandmortyapp.databinding.LocationsFragmentBinding;
import com.example.rickandmortyapp.fragmentactivities.commandpattern.base.BaseActivityCommand;
import com.example.rickandmortyapp.models.episodedata.Episode;
import com.example.rickandmortyapp.models.locationdata.Location;
import com.example.rickandmortyapp.repositories.child.EpisodesRepository;
import com.example.rickandmortyapp.repositories.child.LocationsRepository;
import com.example.rickandmortyapp.response.child.EpisodeResponse;
import com.example.rickandmortyapp.response.child.LocationResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.EpisodesViewModel;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.LocationsViewModel;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.parent.BaseViewModel;

import java.util.List;

public class EpisodeActivityCommand extends BaseActivityCommand<Episode> {

    private EpisodesViewModel viewModel;

    @Override
    public ViewDataBinding getFragmentBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return EpisodesFragmentBinding.inflate(inflater, container, false);
    }

    @Override
    public List<Episode> getData(Object response) {
        return ((EpisodeResponse)response).getEpisodes();
    }

    @Override
    public BaseViewModel<EpisodesRepository, EpisodeResponse> getViewModel(Fragment fragment) {
        if(viewModel == null){
            viewModel = new ViewModelProvider(fragment).get(EpisodesViewModel.class);
        }

        return viewModel;
    }

    @Override
    public ViewDataBinding setAdapter(ViewDataBinding viewDataBinding, DataAdapter adapter) {
        EpisodesFragmentBinding episodesBinding = (( EpisodesFragmentBinding)viewDataBinding);
        episodesBinding.episodesRecycleView.setAdapter(adapter);
        return episodesBinding;
    }

    @Override
    public Boolean getIsLoading(ViewDataBinding dataBinding) {
        EpisodesFragmentBinding episodesBinding = ((EpisodesFragmentBinding)dataBinding);
        return episodesBinding.getIsLoading();
    }

    @Override
    public Boolean getIsLoadingMore(ViewDataBinding dataBinding) {
        EpisodesFragmentBinding episodesBinding = ((EpisodesFragmentBinding)dataBinding);
        return episodesBinding.getIsLoadingMore();
    }

    @Override
    public ViewDataBinding setIsLoadingTrue(ViewDataBinding viewDataBinding) {
        EpisodesFragmentBinding episodesBinding = ((EpisodesFragmentBinding)viewDataBinding);
        episodesBinding.setIsLoading(true);
        return episodesBinding;
    }

    @Override
    public ViewDataBinding setIsLoadingFalse(ViewDataBinding viewDataBinding) {
        EpisodesFragmentBinding episodesBinding = ((EpisodesFragmentBinding)viewDataBinding);
        episodesBinding.setIsLoading(false);
        return episodesBinding;
    }

    @Override
    public ViewDataBinding setIsLoadingMoreTrue(ViewDataBinding viewDataBinding) {
        EpisodesFragmentBinding episodesBinding = ((EpisodesFragmentBinding)viewDataBinding);
        episodesBinding.setIsLoadingMore(true);
        return episodesBinding;
    }

    @Override
    public ViewDataBinding setIsLoadingMoreFalse(ViewDataBinding viewDataBinding) {
        EpisodesFragmentBinding episodesBinding = ((EpisodesFragmentBinding)viewDataBinding);
        episodesBinding.setIsLoadingMore(false);
        return episodesBinding;
    }

    @Override
    public void scrollNotifySender(ViewDataBinding viewDataBinding) {
        EpisodesFragmentBinding episodesBinding = ((EpisodesFragmentBinding)viewDataBinding);
        episodesBinding.episodesRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                scrollListener.notifyOnScrolled(!episodesBinding.episodesRecycleView.canScrollVertically(1));
            }
        });
    }

    @Override
    public int getTotalAvailablePages(Object response) {
        return ((EpisodeResponse)response).getInfo().getPages();
    }



}
