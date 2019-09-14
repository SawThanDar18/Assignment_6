package com.padcmyanmar.padc9.assignment_6.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.padcmyanmar.padc9.assignment_6.R;
import com.padcmyanmar.padc9.assignment_6.data.models.RestaurantModel;
import com.padcmyanmar.padc9.assignment_6.data.models.RestaurantModelImpl;

public class BaseActivity extends AppCompatActivity {

    protected RestaurantModel restaurantModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restaurantModel = RestaurantModelImpl.getObjInstance();
    }

    protected void showSnackbar(String message){
        final Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), message, Snackbar.LENGTH_LONG);
        snackbar.setAction(getString(R.string.snackbar_msg), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
    }
}
