package com.padcmyanmar.padc9.assignment_6.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "menu", foreignKeys = {@ForeignKey(entity = RestaurantsVO.class, parentColumns = "id", childColumns = "restaurant_id")},
        indices = @Index(value = "restaurant_id", unique = true))
public class MenuVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "menu_id_pk")
    private int menuIdPK;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private int menu_id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String menu_name;

    @SerializedName("price")
    @ColumnInfo(name = "price")
    private int price;

    @ColumnInfo(name = "restaurant_id")
    private int restaurantId;

    public int getMenuIdPK() {
        return menuIdPK;
    }

    public void setMenuIdPK(int menuIdPK) {
        this.menuIdPK = menuIdPK;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}
