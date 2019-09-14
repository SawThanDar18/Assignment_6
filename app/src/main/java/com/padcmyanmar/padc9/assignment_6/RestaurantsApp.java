package com.padcmyanmar.padc9.assignment_6;

import android.app.Application;

import com.padcmyanmar.padc9.assignment_6.data.models.RestaurantModelImpl;

public class RestaurantsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RestaurantModelImpl.initializeRestaurantModel(getApplicationContext());
    }
}
