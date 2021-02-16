package com.sampleapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.sampleapp.R;
import com.sampleapp.adapter.ProfileAdapter;
import com.sampleapp.model.ProfileModel;

public class ProfileDetailActivity extends AppCompatActivity  {

    TextView textViewName,textViewContac,textViewDesc,textViewAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);
        textViewName = findViewById(R.id.textViewName);
        textViewContac = findViewById(R.id.textViewContac);
        textViewDesc = findViewById(R.id.textViewDesc);
        textViewAddress = findViewById(R.id.textViewAddress);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();
        if(extras != null)
        {
            String name = extras.getString("name");
            String contact = extras.getString("contact");
            String desc = extras.getString("desc");
            String address = extras.getString("address");
            Log.e("name12","name12 "+name);
            textViewName.setText(name);
            textViewContac.setText(contact);
            textViewDesc.setText(desc);
            textViewAddress.setText(address);

        }
    }


}