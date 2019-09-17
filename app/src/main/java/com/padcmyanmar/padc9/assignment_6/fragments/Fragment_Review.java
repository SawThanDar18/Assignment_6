package com.padcmyanmar.padc9.assignment_6.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.padc9.assignment_6.R;
import com.padcmyanmar.padc9.assignment_6.delegates.DetailDelegate;

import butterknife.ButterKnife;

public class Fragment_Review extends Fragment {

    private static DetailDelegate detailDelegate;

    public Fragment_Review() {
    }

    @SuppressLint("ValidFragment")
    public Fragment_Review(DetailDelegate detailDelegate){
        this.detailDelegate = detailDelegate;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  LayoutInflater.from(container.getContext()).inflate(R.layout.fragment__review, container, false);

        ButterKnife.bind(this, view);
        detailDelegate.showReview(getActivity(), view);

        return view;
    }

}
