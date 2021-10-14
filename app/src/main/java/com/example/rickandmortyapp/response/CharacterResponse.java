package com.example.rickandmortyapp.response;

import com.example.rickandmortyapp.models.Character;
import com.example.rickandmortyapp.models.CharacterInfo;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterResponse {

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
