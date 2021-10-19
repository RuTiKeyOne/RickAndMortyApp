package com.example.rickandmortyapp.activities.commandpatter.parent;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.LifecycleObserver;

public abstract class BaseIntentCommand<Data> implements LifecycleObserver {


    public abstract Intent executeCommandActivity(Context context);

}
