package com.dailybenefit1k.repository.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataJson {

    @SerializedName("userArray")
    @Expose
    private UserArray userArray;

    @SerializedName("dietArray")
    @Expose
    private DietArray dietArray;



    public UserArray getUserArray() {
        return userArray;
    }

    public void setUserArray(UserArray userArray) {
        this.userArray = userArray;
    }

    public DietArray getDietArray() {
        return dietArray;
    }

    public void setDietArray(DietArray dietArray) {
        this.dietArray = dietArray;
    }

}