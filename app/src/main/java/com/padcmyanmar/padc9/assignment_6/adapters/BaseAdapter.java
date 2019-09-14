package com.padcmyanmar.padc9.assignment_6.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.padcmyanmar.padc9.assignment_6.views.holders.BaseHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T extends BaseHolder<W>, W> extends RecyclerView.Adapter<T> {

    private List<W> mData;

    public BaseAdapter() {
        this.mData = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(@NonNull T viewHolder, int position) {
        viewHolder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<W> data){
        mData = data;
        notifyDataSetChanged();
    }
}
