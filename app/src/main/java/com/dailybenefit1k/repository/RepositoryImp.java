package com.dailybenefit1k.repository;


import android.content.Context;

import com.dailybenefit1k.di.scope.ApplicationContext;
import com.dailybenefit1k.repository.pref.PrefStorage;

import javax.inject.Singleton;

//@Singleton
public class RepositoryImp implements Repository {

    private  Context context;
    private  PrefStorage prefStorage;

//    public RepositoryImp(@ApplicationContext Context context, PrefStorage prefStorage) {
//        this.context = context;
//        this.prefStorage = prefStorage;
//
//    }
}
