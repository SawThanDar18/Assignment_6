package com.padcmyanmar.padc9.assignment_6.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.padcmyanmar.padc9.assignment_6.delegates.DetailDelegate;
import com.padcmyanmar.padc9.assignment_6.fragments.Fragment_Detail;
import com.padcmyanmar.padc9.assignment_6.fragments.Fragment_Menu;
import com.padcmyanmar.padc9.assignment_6.fragments.Fragment_Review;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private static DetailDelegate detailDelegate;

    public TabPagerAdapter(FragmentManager fm, DetailDelegate detailDelegate) {
        super(fm);
        this.detailDelegate = detailDelegate;
    }

    @Override
    public Fragment getItem(int i) {
        if(i == 0){
            return new Fragment_Detail(detailDelegate);
        }else if(i == 1){
            return new Fragment_Menu(detailDelegate);
        }else return new Fragment_Review(detailDelegate);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return  "DETAILS";
        }else if(position == 1){
            return "MENU";
        }else return "REVIEWS";
    }
}
