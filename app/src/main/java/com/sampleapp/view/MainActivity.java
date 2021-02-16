package com.sampleapp.view;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.sampleapp.R;
import com.sampleapp.adapter.ProfileAdapter;
import com.sampleapp.model.ProfileModel;
import com.sampleapp.viewmodel.ProfileViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements ProfileAdapter.ItemClickListner {

    ArrayList<ProfileModel> profileArrayList = new ArrayList<>();
    ProfileAdapter profileAdapter;
    private ProfileViewModel profileViewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        profileAdapter = new ProfileAdapter(this, profileArrayList, this);

        recyclerView.setAdapter(profileAdapter);
        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);

        profileViewModel.getProfileListOberver().observe(this, newsResponse -> {
            List<ProfileModel> profilelists = newsResponse.getSuccess();
            profileArrayList.addAll(profilelists);

            profileAdapter.notifyDataSetChanged();
        });


        profileViewModel.makeApiCall();

    }

    @Override
    public void onProfileClick(ProfileModel profileModel) {

      //  Toast.makeText(this, profileModel.getName(), Toast.LENGTH_LONG).show();

    }
}