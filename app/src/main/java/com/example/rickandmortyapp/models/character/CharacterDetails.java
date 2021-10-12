package com.example.rickandmortyapp.models.character;

import com.example.rickandmortyapp.models.Details;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterDetails extends Details {

    @SerializedName("results")
    List<Character> characters;
}
