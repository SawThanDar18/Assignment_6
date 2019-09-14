package com.padcmyanmar.padc9.assignment_6.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.padcmyanmar.padc9.assignment_6.R;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsVO;
import com.padcmyanmar.padc9.assignment_6.delegates.DetailDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Fragment_One extends Fragment {

    private DetailDelegate detailDelegate;
    private RestaurantsVO restaurantsVO;

    @BindView(R.id.detail_name)
    TextView detail_name;

    @BindView(R.id.detail_desc)
    TextView detail_desc;

    @BindView(R.id.detail_time)
    TextView detail_time;

    @BindView(R.id.floatingActionButton)
    FloatingActionButton map;

    private static final String BUNDLE_RESTAURANT = "bundle";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragments, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailDelegate.onFloatingButtonClicked(restaurantsVO);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        detailDelegate = (DetailDelegate) context;
    }

    private void bindData(RestaurantsVO restaurantsVO){
        /*detail_name.setText(restaurantsVO.getName());
        detail_desc.setText(restaurantsVO.getDescription());
        detail_time.setText(restaurantsVO.getTimeVO().getOpening_time() + "-" + restaurantsVO.getTimeVO().getClosing_time());*/
    }
}
