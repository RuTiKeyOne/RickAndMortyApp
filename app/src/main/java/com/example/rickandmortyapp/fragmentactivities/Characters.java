package com.example.rickandmortyapp.fragmentactivities;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rickandmortyapp.adapters.recycleviewadapter.child.CharactersAdapter;
import com.example.rickandmortyapp.databinding.CharactersFragmentBinding;
import com.example.rickandmortyapp.models.characterdata.Character;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.CharactersViewModel;

import java.util.ArrayList;
import java.util.List;

public class Characters extends Fragment {

    private CharactersViewModel charactersViewModel;
    private CharactersFragmentBinding charactersBinding;
    private List<Character> characters = new ArrayList<>();
    private CharactersAdapter adapter;

    private int currentPage = 1;
    private int totalAvailablePages = 1;

    public static Characters newInstance() {
        return new Characters();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        initializeComponentsView(inflater, container, savedInstanceState);
        getCharacters();
        return setInitialView();
    }

    private View setInitialView(){
        View view = charactersBinding.getRoot();
        return view;
    }


    private void initializeComponentsView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                          @Nullable Bundle savedInstanceState) {
        charactersBinding = CharactersFragmentBinding.inflate(inflater, container, false);
        charactersViewModel = new ViewModelProvider(this).get(CharactersViewModel.class);
        adapter = new CharactersAdapter(characters);
        charactersBinding.charactersRecycleView.setAdapter(adapter);
        ScrollRecycleViewManager();
    }

    private void getCharacters() {
        toggleLoadingManager();
        charactersViewModel.getDataByPage(currentPage).observe(getViewLifecycleOwner(), characterResponse -> {
            if (characterResponse != null) {
                totalAvailablePages = characterResponse.getInfo().getPages();
                characters.addAll(characterResponse.getCharacters());
                adapter.notifyDataSetChanged();
                toggleLoadingManager();
            }
        });
    }

    private void toggleLoadingManager(){
        if(currentPage == 1){
            toggleStartLoading();
        }else{
            toggleMoreLoading();
        }
    }

    private void toggleStartLoading() {
        if (charactersBinding.getIsLoading() != null && charactersBinding.getIsLoading()) {
            charactersBinding.setIsLoading(false);
        } else {
            charactersBinding.setIsLoading(true);
        }
    }

    private void toggleMoreLoading() {
        if (charactersBinding.getIsLoadingMore() != null && charactersBinding.getIsLoadingMore()) {
            charactersBinding.setIsLoadingMore(false);
        } else {
            charactersBinding.setIsLoadingMore(true);
        }
    }

    private void ScrollRecycleViewManager() {
        charactersBinding.charactersRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!charactersBinding.charactersRecycleView.canScrollVertically(1) && currentPage <= totalAvailablePages) {
                    currentPage += 1;
                    getCharacters();
                }
            }
        });
    }

}