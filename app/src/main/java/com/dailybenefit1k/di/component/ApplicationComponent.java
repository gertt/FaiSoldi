package com.dailybenefit1k.di.component;

import android.content.Context;
import com.dailybenefit1k.app.App;
import com.dailybenefit1k.di.module.ApplicationModule;
import com.dailybenefit1k.di.module.NetworkModule;
import com.dailybenefit1k.di.scope.ApplicationContext;
import com.dailybenefit1k.repository.Repository;
import com.dailybenefit1k.repository.network.API;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void injectApplication(App app);


    API getApi();

    @ApplicationContext
    Context context();

    Repository getRepository();
}
