package com.example.rickandmortyapp.adapters.recycleviewadapter.parent;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortyapp.adapters.recycleviewadapter.command.base.BaseCommand;

public class DataViewHolder<T extends ViewDataBinding, D> extends RecyclerView.ViewHolder {

    BaseCommand command;
    T dataBinding;

    public DataViewHolder(@NonNull T dataBinding, @NonNull BaseCommand command) {
        super(dataBinding.getRoot());
        this.dataBinding = dataBinding;
        this.command = command;
    }

    public void bindData(D data){
        command.bindData(data, dataBinding);
    }
}
