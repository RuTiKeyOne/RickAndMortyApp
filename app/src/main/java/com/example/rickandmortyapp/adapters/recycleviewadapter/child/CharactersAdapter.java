package com.example.rickandmortyapp.adapters.recycleviewadapter.child;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortyapp.R;
import com.example.rickandmortyapp.adapters.recycleviewadapter.command.base.BaseCommand;
import com.example.rickandmortyapp.adapters.recycleviewadapter.command.child.CharacterCommands;
import com.example.rickandmortyapp.adapters.recycleviewadapter.parent.DataAdapter;
import com.example.rickandmortyapp.adapters.recycleviewadapter.parent.DataViewHolder;
import com.example.rickandmortyapp.databinding.ItemCharacterContainerBinding;
import com.example.rickandmortyapp.models.characterdata.Character;

import java.util.List;

public class CharactersAdapter<T> extends DataAdapter<Character, Integer> {

    public CharactersAdapter(List<Character> data, BaseCommand command, int idLayout) {
        super(data, command, idLayout);
    }
}
