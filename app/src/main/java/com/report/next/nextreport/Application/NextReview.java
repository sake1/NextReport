package com.report.next.nextreport.Application;

import android.app.Application;

import com.report.next.nextreport.Class.TypefaceUtil;

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
