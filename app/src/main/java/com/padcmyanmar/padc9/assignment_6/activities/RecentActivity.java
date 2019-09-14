package com.padcmyanmar.padc9.assignment_6.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.padcmyanmar.padc9.assignment_6.R;
import com.padcmyanmar.padc9.assignment_6.data.vos.RecentVO;
import com.padcmyanmar.padc9.assignment_6.persistence.RestaurantDB;

import butterknife.BindView;

public class RecentActivity extends BaseActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.recent_recyclerView)
    RecyclerView recent_recyclerView;

    @BindView(R.id.recent_tv)
    TextView recent_tv;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, RecentActivity.class);
        return intent;
    }

    private RestaurantDB restaurantDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);

        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL, false));

        recent_recyclerView.setVisibility(View.INVISIBLE);
        recent_tv.setVisibility(View.INVISIBLE);

        final EditText search_et = findViewById(R.id.search_et);
        search_et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    String value = search_et.getText().toString().trim();

                    RecentVO recentVO = new RecentVO();
                    restaurantDB = RestaurantDB.getObjInstance(getApplicationContext());
                }
                return false;
            }
        });
    }
}
