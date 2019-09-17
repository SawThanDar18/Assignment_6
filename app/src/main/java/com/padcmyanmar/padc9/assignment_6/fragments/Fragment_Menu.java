package com.padcmyanmar.padc9.assignment_6.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.padcmyanmar.padc9.assignment_6.R;
import com.padcmyanmar.padc9.assignment_6.adapters.MenuAdapter;
import com.padcmyanmar.padc9.assignment_6.delegates.DetailDelegate;

import butterknife.ButterKnife;

public class Fragment_Menu extends Fragment {

    private DetailDelegate detailDelegate;

    public Fragment_Menu() {
    }

    @SuppressLint("ValidFragment")
    public Fragment_Menu(DetailDelegate detailDelegate){
        this.detailDelegate = detailDelegate;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_menu, container, false);

        ButterKnife.bind(this, view);

        detailDelegate.showMenu(getActivity(), view);

        return view;
    }

}
