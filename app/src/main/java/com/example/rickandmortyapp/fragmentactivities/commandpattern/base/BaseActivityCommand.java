package com.example.rickandmortyapp.fragmentactivities.commandpattern.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.example.rickandmortyapp.adapters.recycleviewadapter.parent.DataAdapter;
import com.example.rickandmortyapp.fragmentactivities.commandpattern.interfaces.ScrollListener;
import com.example.rickandmortyapp.fragmentactivities.parent.BaseFragmentActivity;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.parent.BaseViewModel;

import java.util.List;

public abstract class BaseActivityCommand<Data> {

    protected ScrollListener scrollListener;

    public void setListener(BaseFragmentActivity activity){
        scrollListener = activity;
    }

    public View setInitialView(ViewDataBinding dataBinding) {
        View view = dataBinding.getRoot();
        return view;
    }

    public abstract ViewDataBinding getFragmentBinding(@NonNull LayoutInflater inflater,
                                                       @Nullable ViewGroup container);

    public abstract List<Data> getData(Object response);

    public int getTotalAvailablePages(Object response) { return 1; }

    public abstract BaseViewModel getViewModel(Fragment fragment);

    public abstract ViewDataBinding setAdapter(ViewDataBinding viewDataBinding, DataAdapter adapter);

    public abstract Boolean getIsLoading(ViewDataBinding dataBinding);

    public abstract Boolean getIsLoadingMore(ViewDataBinding dataBinding);

    public abstract ViewDataBinding setIsLoadingTrue(ViewDataBinding viewDataBinding);

    public abstract ViewDataBinding setIsLoadingFalse(ViewDataBinding viewDataBinding);

    public abstract ViewDataBinding setIsLoadingMoreTrue(ViewDataBinding viewDataBinding);

    public abstract ViewDataBinding setIsLoadingMoreFalse(ViewDataBinding viewDataBinding);

    public abstract void scrollNotifySender(ViewDataBinding viewDataBinding);

}
