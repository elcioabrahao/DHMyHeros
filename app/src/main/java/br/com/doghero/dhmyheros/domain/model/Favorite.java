package br.com.doghero.dhmyheros.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Favorite implements Serializable
{

    @SerializedName("is_superhero")
    @Expose
    private Boolean isSuperhero;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("address_neighborhood")
    @Expose
    private String addressNeighborhood;
    @SerializedName("price")
    @Expose
    private Integer price;
    private final static long serialVersionUID = -5286734397733633487L;

    public Boolean getIsSuperhero() {
        return isSuperhero;
    }

    public void setIsSuperhero(Boolean isSuperhero) {
        this.isSuperhero = isSuperhero;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddressNeighborhood() {
        return addressNeighborhood;
    }

    public void setAddressNeighborhood(String addressNeighborhood) {
        this.addressNeighborhood = addressNeighborhood;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}