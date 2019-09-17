package com.padcmyanmar.padc9.assignment_6.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.padcmyanmar.padc9.assignment_6.R;
import com.padcmyanmar.padc9.assignment_6.data.vos.MenuVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuItemViewHolder extends BaseHolder<MenuVO> {

    @BindView(R.id.menu_name)
    TextView menu_name;

    @BindView(R.id.menu_price)
    TextView menu_price;

    public MenuItemViewHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(MenuVO data) {
        menu_name.setText(data.getMenu_name());
        menu_price.setText(data.getPrice());
    }
}
