package com.sampleapp.network;

import com.sampleapp.model.MainModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("tracking/viewreport")
    Call<MainModel>getProfileList();
}
