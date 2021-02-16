package com.sampleapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sampleapp.model.MainModel;
import com.sampleapp.network.APIService;
import com.sampleapp.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileViewModel extends ViewModel {
    private MutableLiveData<MainModel> profileList;

    public ProfileViewModel() {
        profileList = new MutableLiveData<>();


    }

    public MutableLiveData<MainModel> getProfileListOberver() {
        return profileList;
    }

    public void makeApiCall() {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<MainModel> call = apiService.getProfileList();
        call.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                profileList.postValue(response.body());

            }

            @Override
            public void onFailure(Call<MainModel> call, Throwable t) {
                profileList.postValue(null);
            }
        });

    }
}
