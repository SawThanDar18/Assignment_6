package com.padcmyanmar.padc9.assignment_6.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.padcmyanmar.padc9.assignment_6.data.vos.MenuVO;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsVO;
import com.padcmyanmar.padc9.assignment_6.persistence.daos.MenuDao;
import com.padcmyanmar.padc9.assignment_6.persistence.daos.RestaurantDao;
import com.padcmyanmar.padc9.assignment_6.utils.Constants;

@Database(entities = {RestaurantsVO.class, MenuVO.class}, version = 13, exportSchema = false)
public abstract class RestaurantDB extends RoomDatabase {

    public abstract RestaurantDao restaurantDao();
    public abstract MenuDao menuDao();

    private static RestaurantDB objInstance;

    public static RestaurantDB getObjInstance(Context context){
        if (objInstance == null){
            objInstance = Room.databaseBuilder(context, RestaurantDB.class, Constants.RESTAURANT_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return objInstance;
    }

    public boolean areDatasExistInDB(){
        return !restaurantDao().getAllFromDB().isEmpty();
    }
}
