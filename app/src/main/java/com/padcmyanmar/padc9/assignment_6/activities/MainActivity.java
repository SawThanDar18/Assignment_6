package com.padcmyanmar.padc9.assignment_6.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.padcmyanmar.padc9.assignment_6.R;
import com.padcmyanmar.padc9.assignment_6.adapters.RecyclerAdapter;
import com.padcmyanmar.padc9.assignment_6.data.models.RestaurantModel;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsVO;
import com.padcmyanmar.padc9.assignment_6.delegates.ItemClicked;

import java.util.List;

public class MainActivity extends BaseActivity implements ItemClicked {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_camera:
                    return true;
                case R.id.navigation_notifications:
                    return true;
                case R.id.navigation_profile:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL, false));

        final RecyclerAdapter adapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(adapter);

        restaurantModel.getAllRestaurants(new RestaurantModel.GetDataFromNetwork() {
            @Override
            public void onSuccess(List<RestaurantsVO> restaurantsVOS) {
                adapter.setNewData(restaurantsVOS);
            }

            @Override
            public void onFailure(String errorMessage) {
                showSnackbar(errorMessage);
            }
        });

        ImageView search_iv = findViewById(R.id.search_iv);
        search_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = RecentActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClicked(int id) {
        Intent intent = DetailActivity.newIntent(getApplicationContext(), id);
        startActivity(intent);
    }
}
