package com.padcmyanmar.padc9.assignment_6.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.padc9.assignment_6.R;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsVO;
import com.padcmyanmar.padc9.assignment_6.delegates.ItemClicked;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemViewHolder extends BaseHolder<RestaurantsVO>{

    private ItemClicked itemClicked;

    @BindView(R.id.restaurant_images)
    ImageView restaurant_images;

    @BindView(R.id.restaurant_name)
    TextView restaurant_name;

    @BindView(R.id.rating)
    TextView rating;

    @BindView(R.id.restaurant_description)
    TextView restaurant_description;

    public ItemViewHolder(@NonNull View itemView, final ItemClicked itemClicked) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        this.itemClicked = itemClicked;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClicked.onClicked(mData.getId());
            }
        });
    }

    @Override
    public void bindData(RestaurantsVO data) {

        mData = data;  //bind data

        Glide.with(itemView).load(data.getImage()).into(restaurant_images);
        restaurant_name.setText(data.getName());
        rating.setText(data.getRating());
        restaurant_description.setText(data.getDescription());
    }
}
