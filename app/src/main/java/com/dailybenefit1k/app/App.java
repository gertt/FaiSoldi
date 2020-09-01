package com.dailybenefit1k.app;

import android.app.Application;

import com.dailybenefit1k.di.component.ApplicationComponent;

import com.dailybenefit1k.di.component.DaggerApplicationComponent;
import com.dailybenefit1k.di.module.ApplicationModule;
import com.dailybenefit1k.di.module.NetworkModule;
import com.facebook.stetho.Stetho;
import java.io.File;

public class App extends Application {

    private ApplicationComponent component;


   //@Inject
  // Repository repository;

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        File cacheFile = new File(getCacheDir(), "responses");

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(cacheFile))
                .build();

        component.injectApplication(this);


    }

    public void setComponent(ApplicationComponent component) {
        this.component = component;
    }

    public ApplicationComponent getComponent() {
        return component;
    }

}




