package com.padcmyanmar.padc9.assignment_6.data.models;

import com.padcmyanmar.padc9.assignment_6.data.vos.MenuVO;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsVO;

import java.util.List;

public interface RestaurantModel {

    void getAllRestaurants(GetDataFromNetwork delegate);

    //void getAllMenus(GetMenusData delegate);

    RestaurantsVO findById(int restaurantId);

    List<MenuVO> getAllMenuById(int menuId);

    List<RestaurantsVO> getRestaurantByName(String name);

    interface GetDataFromNetwork{
        void onSuccess(List<RestaurantsVO> restaurantsVOS);
        void onFailure(String errorMessage);
    }

    /*interface GetMenusData{
        void onSuccess(List<MenuVO> menuVOS);
        void onFailure(String errorMessage);
    }*/
}
