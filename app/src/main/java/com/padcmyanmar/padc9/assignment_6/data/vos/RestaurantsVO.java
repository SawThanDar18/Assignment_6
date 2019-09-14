package com.padcmyanmar.padc9.assignment_6.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "restaurant", indices = @Index(value = "id", unique = true))
public class RestaurantsVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "restaurant_id_pk")
    private int restaurantIdPK;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private int id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("imageUrl")
    @ColumnInfo(name = "image_url")
    private String image;

    @SerializedName("address")
    @ColumnInfo(name = "address")
    private String address;

    @SerializedName("description")
    @ColumnInfo(name = "description")
    private String description;

    @SerializedName("opening_closing_times")
    @Embedded(prefix = "opening_closing_times_")
    private TimeVO timeVO;

    @SerializedName("rating")
    @ColumnInfo(name = "rating")
    private String rating;

    @SerializedName("restaurant_location")
    @Embedded(prefix = "restaurant_location_")
    private LocationVO locationVO;

    @SerializedName("menus")
    @Ignore
    private List<MenuVO> menuVO;

    public int getRestaurantIdPK() {
        return restaurantIdPK;
    }

    public void setRestaurantIdPK(int restaurantIdPK) {
        this.restaurantIdPK = restaurantIdPK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TimeVO getTimeVO() {
        return timeVO;
    }

    public void setTimeVO(TimeVO timeVO) {
        this.timeVO = timeVO;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public LocationVO getLocationVO() {
        return locationVO;
    }

    public void setLocationVO(LocationVO locationVO) {
        this.locationVO = locationVO;
    }

    public List<MenuVO> getMenuVO() {
        return menuVO;
    }

    public void setMenuVO(List<MenuVO> menuVO) {
        this.menuVO = menuVO;
    }
}