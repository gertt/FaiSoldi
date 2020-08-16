package com.dailybenefit1k.di.module;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.dailybenefit1k.app.App;
import com.dailybenefit1k.di.scope.ApplicationContext;
import com.dailybenefit1k.di.scope.PreferenceInfo;
import com.dailybenefit1k.repository.pref.PrefStorage;
import com.dailybenefit1k.repository.pref.PrefStorageImp;
import com.dailybenefit1k.ui.email.EmailMenu;
import com.dailybenefit1k.ui.email.EmailMenuPreImpl;
import com.dailybenefit1k.util.Contants;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class EmailModule {

    private App appCompatActivity;

    public EmailModule(App appCompatActivity){
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return appCompatActivity;
    }

    @Provides
    @PreferenceInfo
    static String provideDatabaseName() {
        return Contants.EMAIL_PATERN;
    }

    @Provides
    @Singleton
    static PrefStorage providePred(PrefStorageImp prefStorageImp){
        return prefStorageImp;
    }

    @Provides
    static EmailMenu.Presenter provideEmailMenuPresenter(EmailMenuPreImpl<EmailMenu.View> emailMenuPreImpl){
        return emailMenuPreImpl;
    }
}
