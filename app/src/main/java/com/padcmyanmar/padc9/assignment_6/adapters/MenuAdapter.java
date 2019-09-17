package com.padcmyanmar.padc9.assignment_6.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.padc9.assignment_6.R;
import com.padcmyanmar.padc9.assignment_6.data.vos.MenuVO;
import com.padcmyanmar.padc9.assignment_6.views.holders.MenuItemViewHolder;

public class MenuAdapter extends BaseAdapter<MenuItemViewHolder, MenuVO> {

    @NonNull
    @Override
    public MenuItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menu_item_view, viewGroup, false);
        return new MenuItemViewHolder(view);
    }
}
