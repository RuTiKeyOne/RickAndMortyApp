package com.example.rickandmortyapp.adapters.recycleviewadapter.child;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.databinding.ItemCharacterContainerBinding;
import com.example.rickandmortyapp.models.characterdata.Character;

import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder> {

    private List<Character> characters;
    private LayoutInflater layoutInflater;

    public CharactersAdapter(List<Character> characters) {
        this.characters = characters;
    }

    @NonNull
    @Override
    public CharactersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        ItemCharacterContainerBinding characterBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_character_container,
                parent, false);
        return new CharactersViewHolder(characterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersViewHolder holder, int position) {
        holder.bindCharacter(characters.get(position));
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class CharactersViewHolder extends RecyclerView.ViewHolder{

        ItemCharacterContainerBinding characterBinding;

        public CharactersViewHolder(@NonNull ItemCharacterContainerBinding characterBinding) {
            super(characterBinding.getRoot());
            this.characterBinding = characterBinding;
        }

        public void bindCharacter(Character character){
            characterBinding.setCharacter(character);
        }
    }

}
