package com.example.rickandmortyapp.fragment_activities.parent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.base.BaseCommand;
import com.example.rickandmortyapp.adapters.recycleviewadapter.parent.DataAdapter;
import com.example.rickandmortyapp.fragment_activities.commandpattern.base.BaseActivityCommand;
import com.example.rickandmortyapp.fragment_activities.commandpattern.interfaces.ScrollListener;
import com.example.rickandmortyapp.response.parent.Response;
import com.example.rickandmortyapp.viewmodels.viewmodelfragment.parent.BaseViewModel;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class BaseFragmentActivity<Data> extends Fragment implements ScrollListener {
    protected BaseViewModel viewModel;
    protected ViewDataBinding fragmentBinding;
    protected List<Data> data = new ArrayList<>();
    protected DataAdapter adapter;
    private BaseActivityCommand baseActivityCommand;
    private BaseCommand baseCommand;
    private int idLayout;
    private Response response;

    private int currentPage = 1;
    private int totalAvailablePages = 1;

    public BaseFragmentActivity(BaseActivityCommand baseActivityCommand, BaseCommand baseCommand,
                                int idLayout, Response response) {
        this.baseActivityCommand = baseActivityCommand;
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
        scrollRecycleViewManager();
        return setInitialView();
    }

    private View setInitialView() {
        return baseActivityCommand.setInitialView(fragmentBinding);
    }

    private void initializeComponentsView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                          @Nullable Bundle savedInstanceState) {
        viewModel = baseActivityCommand.getViewModel(this);
        adapter = new DataAdapter(data, baseCommand, idLayout);
        fragmentBinding = baseActivityCommand.getFragmentBinding(inflater, container);
        fragmentBinding = baseActivityCommand.setAdapter(fragmentBinding, adapter);
        baseActivityCommand.setListener(this);

    }



    private void getData() {
        LoadManager();
        viewModel.getDataByPage(currentPage).observe(getViewLifecycleOwner(), response -> {
            if (baseActivityCommand.getData(response) != null) {
                totalAvailablePages = baseActivityCommand.getTotalAvailablePages(response);
                data.addAll(baseActivityCommand.getData(response));
                adapter.notifyDataSetChanged();
                LoadManager();
            } else {

            }
        });
    }

    private Boolean checkInternetConnection() {
        try {
            URL url = new URL("http://www.instanceofjava.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            return  true;
        } catch (Exception e) {
            return false;
        }
    }


    private void LoadManager() {
        if (currentPage == 1) {
            isLoadingManager();
        } else {
            isLoadingMoreManager();
        }
    }

    private void isLoadingManager() {
        if (baseActivityCommand.getIsLoading(fragmentBinding) != null && baseActivityCommand.getIsLoading(fragmentBinding)) {
            fragmentBinding = baseActivityCommand.setIsLoadingFalse(fragmentBinding);
        } else {
            fragmentBinding = baseActivityCommand.setIsLoadingTrue(fragmentBinding);
        }
    }

    private void isLoadingMoreManager() {
        if (baseActivityCommand.getIsLoadingMore(fragmentBinding) != null && baseActivityCommand.getIsLoadingMore(fragmentBinding)) {
            fragmentBinding = baseActivityCommand.setIsLoadingMoreFalse(fragmentBinding);
        } else {
            fragmentBinding = baseActivityCommand.setIsLoadingMoreTrue(fragmentBinding);
        }
    }

    private void scrollRecycleViewManager() {
        baseActivityCommand.scrollNotifySender(fragmentBinding);
    }


    @Override
    public void notifyOnScrolled(Boolean canScrollVertically) {
        if (canScrollVertically && currentPage < totalAvailablePages) {
            currentPage += 1;
            getData();
        }
    }

}
