package com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

public abstract class BaseCommand<T> {
    public abstract void bindData(T data, ViewDataBinding dataBinding);
    public abstract ViewDataBinding setItemContainerBinding(LayoutInflater layoutInflater,
                                                            int idLayout, ViewGroup parent);
}
