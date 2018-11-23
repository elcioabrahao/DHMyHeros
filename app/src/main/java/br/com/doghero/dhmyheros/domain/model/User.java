package br.com.doghero.dhmyheros.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable
{

    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    private final static long serialVersionUID = 840066297548261905L;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}