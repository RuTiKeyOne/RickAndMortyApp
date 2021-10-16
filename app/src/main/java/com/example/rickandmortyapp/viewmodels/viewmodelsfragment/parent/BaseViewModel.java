package com.example.rickandmortyapp.viewmodels.viewmodelsfragment.parent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.rickandmortyapp.repositories.parent.Repository;
import com.example.rickandmortyapp.response.parent.Response;

public class BaseViewModel<T extends Repository, I extends Response> extends ViewModel {

    protected T repository;

    public LiveData<I> getDataByPage(int page){
        return repository.getDataByPage(page);
    }
}
