package com.example.rickandmortyapp.activities.commandpatter.parent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.LifecycleObserver;

import com.example.rickandmortyapp.activities.child.Activity;
import com.example.rickandmortyapp.response.parent.Response;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.parent.BaseViewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseIntentCommand<Data> implements LifecycleObserver {

    protected List<Data> data = new ArrayList<>();
    protected BaseViewModel viewModel;
    protected Activity activity;
    protected Response response;
    protected int startPage = 1;
    public static final String DATA_KEY = "ARRAYLIST";
    public static final String DATA_INTENT_KEY = "BUNDLEDATA";

    public BaseIntentCommand(BaseViewModel viewModel, Activity activity, Response response) {
        this.viewModel = viewModel;
        this.activity = activity;
        this.response = response;
        getData();
    }

    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(DATA_KEY, (Serializable) this.data);
        return bundle;
    }

    public abstract void getData();

    public abstract Intent executeCommandActivity(Context context);


}
