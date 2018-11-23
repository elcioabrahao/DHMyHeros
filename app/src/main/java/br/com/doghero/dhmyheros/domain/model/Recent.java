package br.com.doghero.dhmyheros.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Recent implements Serializable
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
    @SerializedName("id")
    @Expose
    private Integer id;
    private final static long serialVersionUID = 3549813905126379302L;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Recent(Boolean isSuperhero, User user, String addressNeighborhood, Integer price, Integer id) {
        this.isSuperhero = isSuperhero;
        this.user = user;
        this.addressNeighborhood = addressNeighborhood;
        this.price = price;
        this.id = id;
    }
}