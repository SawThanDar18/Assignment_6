package com.padcmyanmar.padc9.assignment_6.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.padc9.assignment_6.R;
import com.padcmyanmar.padc9.assignment_6.adapters.MenuAdapter;
import com.padcmyanmar.padc9.assignment_6.adapters.TabPagerAdapter;
import com.padcmyanmar.padc9.assignment_6.data.vos.MenuVO;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsVO;
import com.padcmyanmar.padc9.assignment_6.delegates.DetailDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity implements DetailDelegate {

    int id = 0;

    @BindView(R.id.restaurant_image)
    ImageView restaurant_image;

    RestaurantsVO restaurantsVO;

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

        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        int restaurantId = getIntent().getIntExtra(EXTRA_ID_EXTRA, 0);
        restaurantsVO = restaurantModel.findById(restaurantId);
        bindData(restaurantsVO);
    }

    private void bindData(RestaurantsVO restaurantsVO){
        Glide.with(restaurant_image).load(restaurantsVO.getImage()).into(restaurant_image);
    }

    @Override
    public void onFloatingButtonClicked(Context context, View view) {
        String  lattitude = String.valueOf(restaurantsVO.getLocationVO().getLatitude());
        String  longitude = String.valueOf(restaurantsVO.getLocationVO().getLongitude());
        String openInMapPrefix = "google.navigation:q=" + lattitude + "," + longitude;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(openInMapPrefix));
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void showDetail(Context context, View view) {

        TextView detail_name = view.findViewById(R.id.detail_name);
        detail_name.setText(restaurantsVO.getName());

        TextView detail_desc = view.findViewById(R.id.detail_desc);
        detail_desc.setText(restaurantsVO.getDescription());

        TextView detail_time = view.findViewById(R.id.detail_time);
        detail_time.setText(restaurantsVO.getTimeVO().getOpening_time() + "-" + restaurantsVO.getTimeVO().getClosing_time());

    }

    @Override
    public void showMenu(Context context, View view) {

        final List<MenuVO> menuVOList = restaurantModel.getAllMenuById(id);

        final RecyclerView menu_recyclerView = view.findViewById(R.id.menu_recyclerView);
        menu_recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL, false));

        final MenuAdapter menuAdapter = new MenuAdapter();
        menu_recyclerView.setAdapter(menuAdapter);
        menuAdapter.setNewData(menuVOList);
        /*restaurantModel.getAllMenus(new RestaurantModel.GetMenusData() {
            @Override
            public void onSuccess(List<MenuVO> menuVOS) {
                menuAdapter.setNewData(menuVOList);
            }

            @Override
            public void onFailure(String errorMessage) {
                showSnackbar(errorMessage);
            }
        });*/

    }

    @Override
    public void showReview(Context context, View view) {
        TextView review_description = view.findViewById(R.id.review_desc);
        review_description.setText(restaurantsVO.getDescription());
    }
}
