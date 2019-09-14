package com.padcmyanmar.padc9.assignment_6.network.response;

import com.padcmyanmar.padc9.assignment_6.utils.Constants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface RestaurantApi {

    @GET(Constants.GET_RESTAURANTS)
    Call<GetResponse> getAllRestaurants();
}
