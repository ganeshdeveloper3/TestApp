package com.sampleapp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainModel {

    @SerializedName("success")
    @Expose
    private List<ProfileModel> success = null;
    @SerializedName("location")
    @Expose
    private List<Locationmodel> location = null;

    public List<ProfileModel> getSuccess() {
        return success;
    }

    public void setSuccess(List<ProfileModel> success) {
        this.success = success;
    }

    public List<Locationmodel> getLocation() {
        return location;
    }

    public void setLocation(List<Locationmodel> location) {
        this.location = location;
    }

}