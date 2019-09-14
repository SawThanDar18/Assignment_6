package com.padcmyanmar.padc9.assignment_6.data.models;

import android.content.Context;

import com.padcmyanmar.padc9.assignment_6.network.dataagents.DataAgent;
import com.padcmyanmar.padc9.assignment_6.network.dataagents.RetrofitDataAgentImpl;
import com.padcmyanmar.padc9.assignment_6.persistence.RestaurantDB;

public abstract class BaseModel {

    protected DataAgent dataAgent;
    protected RestaurantDB restaurantDB;

    public BaseModel(Context context) {
        dataAgent = RetrofitDataAgentImpl.getObjInstance();
        restaurantDB = RestaurantDB.getObjInstance(context);
    }
}
