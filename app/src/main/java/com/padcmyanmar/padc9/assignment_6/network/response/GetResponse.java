package com.padcmyanmar.padc9.assignment_6.network.response;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.padc9.assignment_6.data.vos.RestaurantsVO;
import com.padcmyanmar.padc9.assignment_6.utils.Constants;

import java.util.List;

public class GetResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<RestaurantsVO> restaurantsVO;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<RestaurantsVO> getRestaurantsVO() {
        return restaurantsVO;
    }

    public void setRestaurantsVO(List<RestaurantsVO> restaurantsVO) {
        this.restaurantsVO = restaurantsVO;
    }

    public boolean isResponseOK(){
        return code == Constants.CODE_RESPONSE_OK && restaurantsVO != null;
    }
}
