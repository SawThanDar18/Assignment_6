package com.padcmyanmar.padc9.assignment_6.views.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseHolder<T> extends RecyclerView.ViewHolder {

    protected T mData;

    public BaseHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bindData(T data);
}
