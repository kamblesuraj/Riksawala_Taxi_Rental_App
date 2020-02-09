package com.example.uber_clone.com.example.uber_clone.Adapters;

import android.location.Location;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;

public class LastKnownLocation {
    private Location mLastLocation;
    private FusedLocationProviderClient mFusedLocationClient;
    LocationRequest mLocationRequest;


//            mFusedLocationClient.getLastLocation()
//                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
//                        @Override
//                        public void onSuccess(Location location) {
//                            if (location != null) {
//                                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
//                                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//                                mMap.animateCamera(CameraUpdateFactory.zoomTo(18));
//
//                            }
//                        }
//                    });
}
