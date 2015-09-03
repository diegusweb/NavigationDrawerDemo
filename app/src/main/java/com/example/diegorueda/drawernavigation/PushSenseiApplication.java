package com.example.diegorueda.drawernavigation;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;


/**
 * Created by diego.rueda on 9/3/2015.
 */
public class PushSenseiApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "vhm9qjsAvXMSBM1336Mvdcjx11JUdOB0kCz6KTiY", "nH3jliFPpld1vk3681GP2UgEzHO22QOdLyoM5l8T");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
