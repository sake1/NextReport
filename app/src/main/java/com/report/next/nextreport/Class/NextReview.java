package com.report.next.nextreport.Class;

import android.app.Application;

/**
 * Created by TimotiusEk on 1/11/2017.
 */
public class NextReview extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Raleway-Black.ttf");
    }
}
