package com.padcmyanmar.padc9.assignment_6.data.vos;

import com.google.gson.annotations.SerializedName;

public class TimeVO {

    @SerializedName("opening_time")
    private String opening_time;

    @SerializedName("closing_time")
    private String closing_time;

    public String getOpening_time() {
        return opening_time;
    }

    public void setOpening_time(String opening_time) {
        this.opening_time = opening_time;
    }

    public String getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(String closing_time) {
        this.closing_time = closing_time;
    }
}
