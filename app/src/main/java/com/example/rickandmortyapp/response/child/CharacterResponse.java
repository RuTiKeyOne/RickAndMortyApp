package com.example.rickandmortyapp.response.child;

import com.example.rickandmortyapp.models.characterdata.Character;
import com.example.rickandmortyapp.models.characterdata.CharacterInfo;
import com.example.rickandmortyapp.response.parent.Response;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterResponse extends Response {

    @SerializedName("info")
    private CharacterInfo info;

    @SerializedName("results")
    private List<Character> characters;

    public List<Character> getCharacters() {
        return characters;
    }

    public CharacterInfo getInfo() {
        return info;
    }
}
