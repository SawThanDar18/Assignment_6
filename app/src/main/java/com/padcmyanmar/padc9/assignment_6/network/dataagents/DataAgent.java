package com.padcmyanmar.padc9.assignment_6.network.dataagents;

import com.padcmyanmar.padc9.assignment_6.data.vos.MenuVO;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsVO;

import java.util.List;

public interface DataAgent {

    void GetRestaurants(GetDataFromNetwork delegate);

    interface GetDataFromNetwork{
        void onSuccess(List<RestaurantsVO> restaurantsVOS);
        void onFailure(String errorMessage);
    }
}
