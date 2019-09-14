package com.padcmyanmar.padc9.assignment_6.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.padcmyanmar.padc9.assignment_6.fragments.Fragment_One;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i == 0){
            return new Fragment_One();
        }else if(i == 1){
            return new Fragment_One();
        }else return new Fragment_One();
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
