package com.example.rickandmortyapp.adapters.recycleviewadapter.command.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseCommand<T> {
    public abstract void bindData(T data, ViewDataBinding dataBinding);
    public abstract ViewDataBinding setItemContainerBinding(LayoutInflater layoutInflater,
                                                            int idLayout, ViewGroup parent);
}
