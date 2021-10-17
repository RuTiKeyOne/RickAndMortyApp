package com.example.rickandmortyapp.fragmentactivities.parent;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.base.BaseCommand;
import com.example.rickandmortyapp.adapters.recycleviewadapter.parent.DataAdapter;
import com.example.rickandmortyapp.fragmentactivities.commandpattern.base.BaseActivityCommand;
import com.example.rickandmortyapp.fragmentactivities.commandpattern.interfaces.ScrollListener;
import com.example.rickandmortyapp.response.parent.Response;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.parent.BaseViewModel;

import java.util.ArrayList;
import java.util.List;


public class BaseFragmentActivity<Data> extends Fragment implements ScrollListener {
    protected BaseViewModel viewModel;
    protected ViewDataBinding fragmentBinding;
    protected List<Data> data = new ArrayList<>();
    protected DataAdapter adapter;
    private BaseActivityCommand command;
    private BaseCommand baseCommand;
    private int idLayout;
    private Response response;

    private int currentPage = 1;
    private int totalAvailablePages = 1;

    public BaseFragmentActivity(BaseActivityCommand command, BaseCommand baseCommand, int idLayout, Response response) {
        this.command = command;
        this.baseCommand = baseCommand;
        this.idLayout = idLayout;
        this.response = response;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        initializeComponentsView(inflater, container, savedInstanceState);
        getData();
        ScrollRecycleViewManager();
        return setInitialView();
    }

    private View setInitialView(){
        return command.setInitialView(fragmentBinding);
    }

    private void initializeComponentsView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                          @Nullable Bundle savedInstanceState){
        viewModel = command.getViewModel(this);
        adapter = new DataAdapter(data, baseCommand, idLayout);
        fragmentBinding = command.getFragmentBinding(inflater, container);
        fragmentBinding = command.setAdapter(fragmentBinding, adapter);
        command.setListener(this);

    }

    private void getData(){
        LoadManager();
        viewModel.getDataByPage(currentPage).observe(getViewLifecycleOwner(), response -> {
            totalAvailablePages  = command.getTotalAvailablePages(response);
            data.addAll(command.getData(response));
            adapter.notifyDataSetChanged();
            LoadManager();
        });
    }


    private void LoadManager(){
        if(currentPage == 1){
            isLoadingManager();
        }else{
            isLoadingMoreManager();
        }
    }

    private void isLoadingManager(){
        if(command.getIsLoading(fragmentBinding) != null && command.getIsLoading(fragmentBinding)){
            fragmentBinding = command.setIsLoadingFalse(fragmentBinding);
        }else{
            fragmentBinding = command.setIsLoadingTrue(fragmentBinding);
        }
    }

    private void isLoadingMoreManager(){
        if(command.getIsLoadingMore(fragmentBinding) != null && command.getIsLoadingMore(fragmentBinding)){
            fragmentBinding = command.setIsLoadingMoreFalse(fragmentBinding);
        }else{
            fragmentBinding = command.setIsLoadingMoreTrue(fragmentBinding);
        }
    }

    private void ScrollRecycleViewManager() {
        command.scrollNotifySender(fragmentBinding);
    }


    @Override
    public void notifyOnScrolled(Boolean canScrollVertically) {
        if(canScrollVertically && currentPage < totalAvailablePages){
            currentPage+=1;
            getData();
        }
    }

}
