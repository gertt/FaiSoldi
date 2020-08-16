package com.dailybenefit1k.app;

import android.app.Application;

import com.dailybenefit1k.di.component.ActivityComponent;
import com.dailybenefit1k.di.component.ApplicationComponent;
import com.dailybenefit1k.di.component.DaggerActivityComponent;
import com.dailybenefit1k.di.component.DaggerApplicationComponent;
import com.dailybenefit1k.di.module.ApplicationModule;
import com.dailybenefit1k.di.module.EmailModule;
import com.dailybenefit1k.di.module.FormModule;
import com.dailybenefit1k.di.module.NetworkModule;
import com.facebook.stetho.Stetho;

import java.io.File;


public class App extends Application {

    private ApplicationComponent component;

    private ActivityComponent   activityComponent ;

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        File cacheFile = new File(getCacheDir(), "responses");

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
              //  .formModule(new FormModule())
                .networkModule(new NetworkModule(cacheFile))
                .build();

        component.inject(this);

        activityComponent = DaggerActivityComponent.builder()
                .emailModule(new EmailModule(this))
                .applicationComponent(((App) getApplicationContext()).getComponent())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}




