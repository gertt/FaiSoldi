package com.dailybenefit1k.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.dailybenefit1k.R;
import com.dailybenefit1k.app.App;
import com.dailybenefit1k.di.component.ActivityComponent;
import com.dailybenefit1k.di.component.DaggerActivityComponent;
import com.dailybenefit1k.di.module.EmailModule;
import com.dailybenefit1k.di.module.NetworkModule;

import java.io.File;

import okhttp3.Cache;

public  abstract class BaseActivity extends AppCompatActivity implements Base.MvpView {


    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mActivityComponent = DaggerActivityComponent.builder()
                .emailModule(new EmailModule(this))
                .applicationComponent(((App) getApplication()).getComponent())
                .build();

    }


    public ActivityComponent getmActivityComponent() {
        return mActivityComponent;
    }

    @Override
    public void  onSucess(){

    }

    @Override
    public void onError() {

    }

    @Override
    public void checkInternetConnection() {

    }
}
