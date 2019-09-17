package com.padcmyanmar.padc9.assignment_6.delegates;

import android.content.Context;
import android.view.View;

public interface DetailDelegate {
    void onFloatingButtonClicked(Context context, View view);
    void showDetail(Context context, View view);
    void showMenu(Context context, View view);
    void showReview(Context context, View view);
}
