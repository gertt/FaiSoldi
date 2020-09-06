package com.dailybenefit1k.di.module;

import android.app.Application;
import android.content.Context;
import com.dailybenefit1k.di.scope.ApplicationContext;
import com.dailybenefit1k.di.scope.PreferenceInfo;
import com.dailybenefit1k.repository.Repository;
import com.dailybenefit1k.repository.RepositoryImp;
import com.dailybenefit1k.repository.network.ApiHelper;
import com.dailybenefit1k.repository.network.ApiHelperImp;
import com.dailybenefit1k.repository.pref.PrefStorage;
import com.dailybenefit1k.repository.pref.PrefStorageImp;
import com.dailybenefit1k.util.Cons;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @PreferenceInfo
    static String providePreferenceName() {
        return Cons.PREFERENCE_VERSION;
    }

    @Provides
    @Singleton
    static PrefStorage providePref(PrefStorageImp prefStorageImp) {
        return prefStorageImp;
    }

    @Provides
    static ApiHelper provideNetwork(ApiHelperImp apiHelperImp) {
        return apiHelperImp;
    }

    @Provides
    static Repository provideRepository(RepositoryImp repositoryImp) {
        return repositoryImp;
    }
}
