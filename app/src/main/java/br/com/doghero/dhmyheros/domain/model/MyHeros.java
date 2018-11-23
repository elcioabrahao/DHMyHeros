package br.com.doghero.dhmyheros.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MyHeros implements Serializable
{

    @SerializedName("recents")
    @Expose
    private List<Recent> recents = null;
    @SerializedName("favorites")
    @Expose
    private List<Favorite> favorites = null;
    private final static long serialVersionUID = -6203465068502864490L;

    private List<HeroItem> heros = null;

    public List<HeroItem> getHeros() {
        return heros;
    }

    public void setHeros(List<HeroItem> heros) {
        this.heros = heros;
    }

    public List<Recent> getRecents() {
        return recents;
    }

    public void setRecents(List<Recent> recents) {
        this.recents = recents;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

}