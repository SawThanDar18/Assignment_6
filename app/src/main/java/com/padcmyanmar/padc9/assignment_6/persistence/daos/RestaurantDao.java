package com.padcmyanmar.padc9.assignment_6.persistence.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.padc9.assignment_6.data.vos.MenuVO;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsAndMenuVO;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsVO;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long[] insertRestaurants(List<RestaurantsVO> restaurantsVOS);

    @Query("SELECT * from restaurant")
    public abstract List<RestaurantsVO> getAllRestaurants();

    @Query("SELECT DISTINCT restaurant.*, menu.* FROM restaurant INNER JOIN menu WHERE restaurant.id = menu.restaurant_id")
    public abstract List<RestaurantsAndMenuVO> getAllFromDB();

    @Query("SELECT * FROM restaurant WHERE id = :id")
    public abstract RestaurantsVO getRestaurantById(int id);

    public void insertRestaurantsAndMenu(List<RestaurantsVO> restaurantsVOList, MenuDao menuDao){
        List<MenuVO> menuVOList = new ArrayList<>();

        for(RestaurantsVO restaurantsVO : restaurantsVOList){
            for (MenuVO menuVO : restaurantsVO.getMenuVO()){
                menuVO.setRestaurantId(restaurantsVO.getId());
            }
            menuVOList.addAll(restaurantsVO.getMenuVO());
        }
        insertRestaurants(restaurantsVOList);
        menuDao.insertMenus(menuVOList);
    }
}
