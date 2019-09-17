package com.padcmyanmar.padc9.assignment_6.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.padcmyanmar.padc9.assignment_6.R;
import com.padcmyanmar.padc9.assignment_6.adapters.RecyclerAdapter;
import com.padcmyanmar.padc9.assignment_6.data.models.RestaurantModel;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsVO;
import com.padcmyanmar.padc9.assignment_6.delegates.ItemClicked;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseActivity implements ItemClicked {

    RecyclerAdapter recyclerAdapter;

    @BindView(R.id.search_recyclerView)
    RecyclerView search_recyclerView;

    @BindView(R.id.back_iv)
    ImageView back_iv;

    @BindView(R.id.search_et)
    EditText search_et;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, SearchActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ButterKnife.bind(this);

        recyclerAdapter = new RecyclerAdapter(this);

        back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        search_et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    String search_keyword = search_et.getText().toString();
                    return true;
                }
                return false;
            }
        });

        search_et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_DEL){
                    restaurantModel.getAllRestaurants(new RestaurantModel.GetDataFromNetwork() {
                        @Override
                        public void onSuccess(List<RestaurantsVO> restaurantsVOS) {
                            recyclerAdapter.setNewData(restaurantsVOS);
                        }

                        @Override
                        public void onFailure(String errorMessage) {
                            showSnackbar(errorMessage);
                        }
                    });
                }
                return false;
            }
        });

        search_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                searchByKeyword(s.toString());
            }
        });
    }

    private void searchByKeyword(String keyword){
        search_recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL, false));
        recyclerAdapter.setNewData(restaurantModel.getRestaurantByName(keyword));
        search_recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onClicked(int id) {
        Intent intent = DetailActivity.newIntent(getApplicationContext(), id);
        startActivity(intent);
    }
}
