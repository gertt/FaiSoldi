package com.dailybenefit1k.di.module;

import android.app.Application;
import android.content.Context;
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

    private Application application;

    public EmailModule(Application application){
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
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
    static EmailMenu.Presenter provideEmailMenuPresenter(EmailMenuPreImpl emailMenuPreImpl){
        return emailMenuPreImpl;
    }
}
