package com.padcmyanmar.padc9.assignment_6.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.padc9.assignment_6.R;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsVO;
import com.padcmyanmar.padc9.assignment_6.delegates.DetailDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment_Detail extends Fragment {

    private DetailDelegate detailDelegate;
    private RestaurantsVO restaurantsVO;

    @BindView(R.id.floatingActionButton)
    FloatingActionButton map;

    public Fragment_Detail(){}

    @SuppressLint("ValidFragment")
    public Fragment_Detail(DetailDelegate detailsDelegate){
        this.detailDelegate = detailsDelegate;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragments, container, false);

        ButterKnife.bind(this, view);

        detailDelegate.showDetail(getActivity(),view);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailDelegate.onFloatingButtonClicked(getActivity(), view);
            }
        });

        return view;
    }
}
