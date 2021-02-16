package com.sampleapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sampleapp.model.MainModel;
import com.sampleapp.network.APIService;
import com.sampleapp.network.RetroInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationViewModel extends ViewModel {
    private MutableLiveData<MainModel> locationList;

    public LocationViewModel() {
        locationList = new MutableLiveData<>();


    }

    public MutableLiveData<MainModel> getLocationListOberver() {
        return locationList;
    }

    public void makeApiCall() {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<MainModel> call = apiService.getProfileList();
        call.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                locationList.postValue(response.body());

            }

            @Override
            public void onFailure(Call<MainModel> call, Throwable t) {
                locationList.postValue(null);
            }
        });

    }
}
