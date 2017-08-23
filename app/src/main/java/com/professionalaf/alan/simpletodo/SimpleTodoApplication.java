package com.professionalaf.alan.simpletodo;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by alan on 8/22/17.
 */

public class SimpleTodoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FlowManager.init(new FlowConfig.Builder(this).build());
        // add for verbose logging
        //FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);
    }
}