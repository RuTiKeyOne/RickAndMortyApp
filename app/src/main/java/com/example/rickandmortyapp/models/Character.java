package com.example.rickandmortyapp.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Character implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("status")
    private String status;

    @SerializedName("species")
    private String species;

    @SerializedName("gender")
    private String gender;

    @SerializedName("image")
    private String imageUrl;

    @SerializedName("created")
    private String createdDate;

    public Character(String name, String status, String species, String gender, String imageUrl, String createdDate) {
        this.name = name;
        this.status = status;
        this.species = species;
        this.gender = gender;
        this.imageUrl = imageUrl;
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
