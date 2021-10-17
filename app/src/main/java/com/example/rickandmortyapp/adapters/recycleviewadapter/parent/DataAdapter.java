package com.example.rickandmortyapp.adapters.recycleviewadapter.parent;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortyapp.adapters.recycleviewadapter.commandpattern.base.BaseCommand;

import java.util.List;


public class DataAdapter<D,T extends Integer> extends RecyclerView.Adapter<DataViewHolder> {

    protected List<D> data;
    private LayoutInflater layoutInflater;
    private BaseCommand command;
    private T idLayout;

    public DataAdapter(List<D> data, BaseCommand command, T idLayout) {
        this.data = data;
        this.command = command;
        this.idLayout = idLayout;
    }


    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        return new DataViewHolder(command.setItemContainerBinding(layoutInflater, idLayout, parent), command);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        holder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
