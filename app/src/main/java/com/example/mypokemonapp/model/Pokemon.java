package com.example.mypokemonapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pokemon implements Serializable {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("pokemonName")
    @Expose
    public String pokemonName;
    @SerializedName("pokemonUrl")
    @Expose
    public String pokemonUrl;
    @SerializedName("pokemonHeight")
    @Expose
    public String pokemonHeight;
    @SerializedName("pokemonWeight")
    @Expose
    public String pokemonWeight;
    @SerializedName("pokemonNextEvolutionA")
    @Expose
    public String pokemonNextEvolutionA;
    @SerializedName("pokemonNextEvolutionB")
    @Expose
    public String pokemonNextEvolutionB;
    @SerializedName("pokemonWeaknessA")
    @Expose
    public String pokemonWeaknessA;
    @SerializedName("pokemonWeaknessB")
    @Expose
    public String pokemonWeaknessB;
    @SerializedName("pokemonWeaknessC")
    @Expose
    public String pokemonWeaknessC;
    @SerializedName("pokemonWeaknessD")
    @Expose
    public String pokemonWeaknessD;
    @SerializedName("pokemonTypeA")
    @Expose
    public String pokemonTypeA;
    @SerializedName("pokemonTypeB")
    @Expose
    public String pokemonTypeB;

    public Pokemon() {
    }

    public Pokemon(Integer id, String pokemonName, String pokemonUrl, String pokemonHeight, String pokemonWeight, String pokemonNextEvolutionA, String pokemonNextEvolutionB, String pokemonWeaknessA, String pokemonWeaknessB, String pokemonWeaknessC, String pokemonWeaknessD, String pokemonTypeA, String pokemonTypeB) {
        this.id = id;
        this.pokemonName = pokemonName;
        this.pokemonUrl = pokemonUrl;
        this.pokemonHeight = pokemonHeight;
        this.pokemonWeight = pokemonWeight;
        this.pokemonNextEvolutionA = pokemonNextEvolutionA;
        this.pokemonNextEvolutionB = pokemonNextEvolutionB;
        this.pokemonWeaknessA = pokemonWeaknessA;
        this.pokemonWeaknessB = pokemonWeaknessB;
        this.pokemonWeaknessC = pokemonWeaknessC;
        this.pokemonWeaknessD = pokemonWeaknessD;
        this.pokemonTypeA = pokemonTypeA;
        this.pokemonTypeB = pokemonTypeB;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonUrl() {
        return pokemonUrl;
    }

    public void setPokemonUrl(String pokemonUrl) {
        this.pokemonUrl = pokemonUrl;
    }

    public String getPokemonHeight() {
        return pokemonHeight;
    }

    public void setPokemonHeight(String pokemonHeight) {
        this.pokemonHeight = pokemonHeight;
    }

    public String getPokemonWeight() {
        return pokemonWeight;
    }

    public void setPokemonWeight(String pokemonWeight) {
        this.pokemonWeight = pokemonWeight;
    }

    public String getPokemonNextEvolutionA() {
        return pokemonNextEvolutionA;
    }

    public void setPokemonNextEvolutionA(String pokemonNextEvolutionA) {
        this.pokemonNextEvolutionA = pokemonNextEvolutionA;
    }

    public String getPokemonNextEvolutionB() {
        return pokemonNextEvolutionB;
    }

    public void setPokemonNextEvolutionB(String pokemonNextEvolutionB) {
        this.pokemonNextEvolutionB = pokemonNextEvolutionB;
    }

    public String getPokemonWeaknessA() {
        return pokemonWeaknessA;
    }

    public void setPokemonWeaknessA(String pokemonWeaknessA) {
        this.pokemonWeaknessA = pokemonWeaknessA;
    }

    public String getPokemonWeaknessB() {
        return pokemonWeaknessB;
    }

    public void setPokemonWeaknessB(String pokemonWeaknessB) {
        this.pokemonWeaknessB = pokemonWeaknessB;
    }

    public String getPokemonWeaknessC() {
        return pokemonWeaknessC;
    }

    public void setPokemonWeaknessC(String pokemonWeaknessC) {
        this.pokemonWeaknessC = pokemonWeaknessC;
    }

    public String getPokemonWeaknessD() {
        return pokemonWeaknessD;
    }

    public void setPokemonWeaknessD(String pokemonWeaknessD) {
        this.pokemonWeaknessD = pokemonWeaknessD;
    }

    public String getPokemonTypeA() {
        return pokemonTypeA;
    }

    public void setPokemonTypeA(String pokemonTypeA) {
        this.pokemonTypeA = pokemonTypeA;
    }

    public String getPokemonTypeB() {
        return pokemonTypeB;
    }

    public void setPokemonTypeB(String pokemonTypeB) {
        this.pokemonTypeB = pokemonTypeB;
    }
}