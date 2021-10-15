package com.example.rickandmortyapp.models.characterdata;

import com.google.gson.annotations.SerializedName;

public class CharacterInfo {

    @SerializedName("count")
    private int count;

    @SerializedName("pages")
    private int pages;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
