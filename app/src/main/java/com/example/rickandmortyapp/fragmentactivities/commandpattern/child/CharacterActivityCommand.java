package com.example.rickandmortyapp.fragmentactivities.commandpattern.child;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortyapp.adapters.recycleviewadapter.parent.DataAdapter;
import com.example.rickandmortyapp.databinding.CharactersFragmentBinding;
import com.example.rickandmortyapp.fragmentactivities.commandpattern.base.BaseActivityCommand;
import com.example.rickandmortyapp.models.characterdata.Character;
import com.example.rickandmortyapp.repositories.child.CharactersRepository;
import com.example.rickandmortyapp.response.child.CharacterResponse;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.child.CharactersViewModel;
import com.example.rickandmortyapp.viewmodels.viewmodelsfragment.parent.BaseViewModel;

import java.util.List;

public class CharacterActivityCommand extends BaseActivityCommand {

    private CharactersViewModel viewModel;

    @Override
    public int getTotalAvailablePages(Object response) {
        return ((CharacterResponse)response).getInfo().getPages();
    }


    @Override
    public Boolean getIsLoading(ViewDataBinding viewDataBinding) {
        CharactersFragmentBinding charactersBinding = ((CharactersFragmentBinding)viewDataBinding);
        return charactersBinding.getIsLoading();
    }

    @Override
    public Boolean getIsLoadingMore(ViewDataBinding viewDataBinding) {
        CharactersFragmentBinding charactersBinding = ((CharactersFragmentBinding)viewDataBinding);
        return charactersBinding.getIsLoadingMore();
    }

    @Override
    public ViewDataBinding getFragmentBinding(@NonNull LayoutInflater inflater,
                                              @Nullable ViewGroup container) {
        return CharactersFragmentBinding.inflate(inflater, container, false);
    }

    @Override
    public List<Character> getData(Object response) {
        return ((CharacterResponse)response).getCharacters();
    }


    @Override
    public BaseViewModel<CharactersRepository, CharacterResponse> getViewModel(Fragment fragment) {
        if(viewModel == null){
            viewModel = new ViewModelProvider(fragment).get(CharactersViewModel.class);
        }

        return viewModel;
    }

    @Override
    public CharactersFragmentBinding setAdapter(ViewDataBinding viewDataBinding, DataAdapter adapter) {
        CharactersFragmentBinding charactersBinding = ((CharactersFragmentBinding)viewDataBinding);
        charactersBinding.charactersRecycleView.setAdapter(adapter);
        return charactersBinding;
    }

    @Override
    public ViewDataBinding setIsLoadingTrue(ViewDataBinding viewDataBinding) {
        CharactersFragmentBinding charactersBinding = ((CharactersFragmentBinding)viewDataBinding);
        charactersBinding.setIsLoading(true);
        return charactersBinding;
    }

    @Override
    public ViewDataBinding setIsLoadingFalse(ViewDataBinding viewDataBinding) {
        CharactersFragmentBinding charactersBinding = ((CharactersFragmentBinding)viewDataBinding);
        charactersBinding.setIsLoading(false);
        return charactersBinding;
    }

    @Override
    public ViewDataBinding setIsLoadingMoreTrue(ViewDataBinding viewDataBinding) {
        CharactersFragmentBinding charactersBinding = ((CharactersFragmentBinding)viewDataBinding);
        charactersBinding.setIsLoadingMore(true);
        return charactersBinding;
    }

    @Override
    public ViewDataBinding setIsLoadingMoreFalse(ViewDataBinding viewDataBinding) {
        CharactersFragmentBinding charactersBinding = ((CharactersFragmentBinding)viewDataBinding);
        charactersBinding.setIsLoadingMore(false);
        return charactersBinding;
    }

    @Override
    public void scrollNotifySender(ViewDataBinding viewDataBinding) {
        CharactersFragmentBinding charactersBinding = ((CharactersFragmentBinding)viewDataBinding);
        charactersBinding.charactersRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                    scrollListener.notifyOnScrolled(!charactersBinding.charactersRecycleView.canScrollVertically(1));
            }
        });
    }


}
