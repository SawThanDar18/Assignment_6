package com.padcmyanmar.padc9.assignment_6.data.models;

import android.content.Context;

import com.padcmyanmar.padc9.assignment_6.data.vos.MenuVO;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsAndMenuVO;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsVO;
import com.padcmyanmar.padc9.assignment_6.network.dataagents.DataAgent;
import com.padcmyanmar.padc9.assignment_6.utils.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantModelImpl extends BaseModel implements RestaurantModel {

    private Map<Integer, RestaurantsVO> dataRepository;

    private static RestaurantModelImpl objInstance;

    private RestaurantModelImpl(Context context){
        super(context);
        dataRepository = new HashMap<>();
    }

    public static void initializeRestaurantModel(Context context){
        objInstance = new RestaurantModelImpl(context);
    }

    public static RestaurantModelImpl getObjInstance(){
        if (objInstance == null){
            throw new RuntimeException(Constants.EM_MODEL_NOT_INITIALIZED);
        }
        return objInstance;
    }

    @Override
    public void getAllRestaurants(final GetDataFromNetwork delegate) {

        if (restaurantDB.areDatasExistInDB()){
            List<RestaurantsAndMenuVO> restaurantsAndMenuFromDB = restaurantDB.restaurantDao().getAllFromDB();

            List<RestaurantsVO> restaurantsFromDB = new ArrayList<>();
            for (RestaurantsAndMenuVO restaurantsAndMenuVO : restaurantsAndMenuFromDB){
                restaurantsAndMenuVO.getRestaurantsVO().setMenuVO(restaurantsAndMenuVO.getMenuVOS());
                restaurantsFromDB.add(restaurantsAndMenuVO.getRestaurantsVO());
            }
            delegate.onSuccess(restaurantsFromDB);
        }else {
            dataAgent.GetRestaurants(new DataAgent.GetDataFromNetwork() {
                @Override
                public void onSuccess(List<RestaurantsVO> restaurantsVOS) {
                    restaurantDB.restaurantDao().insertRestaurantsAndMenu(restaurantsVOS, restaurantDB.menuDao());
                    delegate.onSuccess(restaurantsVOS);
                }

                @Override
                public void onFailure(String errorMessage) {
                    delegate.onFailure(errorMessage);
                }
            });
        }
    }

    /*@Override
    public void getAllMenus(final GetMenusData delegate) {
        if (restaurantDB.areDatasExistInDB()) {
            List<MenuVO> dataFromDB = restaurantDB.menuDao().getAllMenus();
            delegate.onSuccess(dataFromDB);
        } else {
            dataAgent.getAllMenus(new DataAgent.GetMenusData() {
                @Override
                public void onSuccess(List<MenuVO> menus) {
                    restaurantDB.menuDao().insertMenus(menus);
                    delegate.onSuccess(menus);
                }

                @Override
                public void onFailure(String errorMessage) {
                    delegate.onFailure(errorMessage);
                }
            });
        }
    }*/

    @Override
    public RestaurantsVO findById(int restaurantId) {
        RestaurantsVO restaurantsVO = restaurantDB.restaurantDao().getRestaurantById(restaurantId);
        return restaurantsVO;
    }

    @Override
    public List<MenuVO> getAllMenuById(int menuId){
        return restaurantDB.menuDao().getMenusById(menuId);
    }

    @Override
    public List<RestaurantsVO> getRestaurantByName(String name){
        List<RestaurantsVO> restaurantsVOS = restaurantDB.restaurantDao().getAllRestaurants();
        List<RestaurantsVO> search_restaurants = new ArrayList<>();
        for (RestaurantsVO restaurants : restaurantsVOS) {
            if(restaurants.getName().toLowerCase().contains(name.toLowerCase())){
                search_restaurants.add(restaurants);
            }
        }
        return search_restaurants;
    }

}
