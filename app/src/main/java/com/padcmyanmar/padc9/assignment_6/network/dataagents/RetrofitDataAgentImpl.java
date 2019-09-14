package com.padcmyanmar.padc9.assignment_6.network.dataagents;

import com.padcmyanmar.padc9.assignment_6.network.response.GetResponse;
import com.padcmyanmar.padc9.assignment_6.network.response.RestaurantApi;
import com.padcmyanmar.padc9.assignment_6.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements DataAgent {

    private static RetrofitDataAgentImpl objInstance;

    private RestaurantApi restaurantApi;

    public RetrofitDataAgentImpl(){

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        restaurantApi = retrofit.create(RestaurantApi.class);
    }

    public static RetrofitDataAgentImpl getObjInstance(){
        if (objInstance == null){
            objInstance = new RetrofitDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void GetRestaurants(final GetDataFromNetwork delegate) {
        Call<GetResponse> responseCall = restaurantApi.getAllRestaurants();
        responseCall.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
                GetResponse getResponse = response.body();
                delegate.onSuccess(getResponse.getRestaurantsVO());
            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
                delegate.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
