package com.padcmyanmar.padc9.assignment_6.data.vos;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class RestaurantsAndMenuVO {

    @Embedded
    RestaurantsVO restaurantsVO;

    @Relation(parentColumn = "id", entityColumn = "restaurant_id")
    List<MenuVO> menuVOS;

    public RestaurantsVO getRestaurantsVO() {
        return restaurantsVO;
    }

    public void setRestaurantsVO(RestaurantsVO restaurantsVO) {
        this.restaurantsVO = restaurantsVO;
    }

    public List<MenuVO> getMenuVOS() {
        return menuVOS;
    }

    public void setMenuVOS(List<MenuVO> menuVOS) {
        this.menuVOS = menuVOS;
    }
}
