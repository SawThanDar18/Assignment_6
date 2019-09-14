package com.padcmyanmar.padc9.assignment_6.data.models;

import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsVO;

import java.util.List;

public interface RestaurantModel {

    void getAllRestaurants(GetDataFromNetwork delegate);

    RestaurantsVO findById(int restaurantId);

    interface GetDataFromNetwork{
        void onSuccess(List<RestaurantsVO> restaurantsVOS);
        void onFailure(String errorMessage);
    }
}
