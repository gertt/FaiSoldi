package com.dailybenefit1k.ui.base;

import android.support.v7.app.AppCompatActivity;

public  abstract class BaseActivity extends AppCompatActivity implements Base.MvpView {


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
