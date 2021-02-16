package com.sampleapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sampleapp.R;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonLoc,buttonProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        buttonLoc = findViewById(R.id.btnLocaiton);
        buttonProfile = findViewById(R.id.btnProfile);

        buttonLoc.setOnClickListener(this);
        buttonProfile.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v == buttonLoc)
        {
            Intent intent = new Intent(DashBoardActivity.this,MapsActivity.class);
            startActivity(intent);
        }   if (v == buttonProfile)
        {
            Intent intent = new Intent(DashBoardActivity.this,MainActivity.class);
            startActivity(intent);
        }

    }
}