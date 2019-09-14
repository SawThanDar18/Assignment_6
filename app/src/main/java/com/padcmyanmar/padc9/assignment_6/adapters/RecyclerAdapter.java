package com.padcmyanmar.padc9.assignment_6.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.padc9.assignment_6.R;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsVO;
import com.padcmyanmar.padc9.assignment_6.delegates.ItemClicked;
import com.padcmyanmar.padc9.assignment_6.views.holders.ItemViewHolder;

public class RecyclerAdapter extends BaseAdapter<ItemViewHolder, RestaurantsVO> {

    private ItemClicked itemClicked;

    public RecyclerAdapter(ItemClicked itemClicked) {
        this.itemClicked = itemClicked;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item_view, viewGroup, false);
        return new ItemViewHolder(view, itemClicked);
    }
}
