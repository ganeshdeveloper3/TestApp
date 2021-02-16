package com.sampleapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    //http://aryu.co.in/tracking/viewreport

    public static String BASE_URL ="http://aryu.co.in/";
    private static Retrofit retrofit;

    public static Retrofit getRetroClient()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
