package com.padcmyanmar.padc9.assignment_6.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.padc9.assignment_6.R;
import com.padcmyanmar.padc9.assignment_6.adapters.TabPagerAdapter;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsVO;
import com.padcmyanmar.padc9.assignment_6.delegates.DetailDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity implements DetailDelegate {

    @BindView(R.id.restaurant_image)
    ImageView restaurant_image;

    private RestaurantsVO restaurantsVO;

    public static final String EXTRA_ID_EXTRA = "restaurantIdExtra";

    public static Intent newIntent(Context context, int restaurantIdExtra){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_ID_EXTRA, restaurantIdExtra);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);

        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        final int restaurantId = getIntent().getIntExtra(EXTRA_ID_EXTRA, 0);
        final RestaurantsVO restaurantsVO = restaurantModel.findById(restaurantId);
        bindData(restaurantsVO);
    }

    private void bindData(RestaurantsVO restaurantsVO){
        Glide.with(restaurant_image).load(restaurantsVO.getImage()).into(restaurant_image);
    }

    @Override
    public void onFloatingButtonClicked(RestaurantsVO restaurantsVO) {
        String  lattitude = String.valueOf(restaurantsVO.getLocationVO().getLatitude());
        String  longitude = String.valueOf(restaurantsVO.getLocationVO().getLongitude());
        String openInMapPrefix = "google.navigation:q=" + lattitude + "," + longitude;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(openInMapPrefix));
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
