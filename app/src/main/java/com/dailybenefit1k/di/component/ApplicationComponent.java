package com.dailybenefit1k.di.component;

import com.dailybenefit1k.app.App;
import com.dailybenefit1k.di.module.ApplicationModule;
import com.dailybenefit1k.di.module.FormModule;
import com.dailybenefit1k.di.module.NetworkModule;
import com.dailybenefit1k.ui.email.EmailMenuImp;
import com.dailybenefit1k.ui.menu.FormMenu;
import dagger.Component;

@Component( modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(App app);
}
