package com.sampleapp.view;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sampleapp.R;
import com.sampleapp.model.Locationmodel;
import com.sampleapp.viewmodel.LocationViewModel;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<Locationmodel> locationList = new ArrayList<>();
    private LocationViewModel locationViewModel;
    List<Locationmodel> locationmodelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationViewModel = ViewModelProviders.of(this).get(LocationViewModel.class);

        locationViewModel.getLocationListOberver().observe(this, newsResponse -> {

            locationmodelList = newsResponse.getLocation();
            locationList.addAll(locationmodelList);

            addMArker();

        });


        locationViewModel.makeApiCall();


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }

    private void addMArker() {
        if (locationmodelList != null) {
            for (int i = 0; i < locationmodelList.size(); i++) {
                Locationmodel dataSet = locationmodelList.get(i);
                double latitude = dataSet.getLat();
                double longitude = dataSet.getLongg();

                Log.e("latitudeq123", "latitudeq123 " + latitude);
                Log.e("longitude12", "longitude12 " + longitude);
                LatLng sydney = new LatLng(latitude, longitude);
                mMap.addMarker(new MarkerOptions().position(sydney).title("Marker"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            }

        } else {
            Toast.makeText(getApplicationContext(), "There is no location ponts", Toast.LENGTH_SHORT).show();
        }


    }
}