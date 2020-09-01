package com.dailybenefit1k.di.component;

import com.dailybenefit1k.di.module.EmailModule;
import com.dailybenefit1k.di.scope.PerApplication;
import com.dailybenefit1k.ui.email.EmailMenuImp;
import dagger.Component;


@PerApplication
@Component(modules = EmailModule.class ,dependencies = ApplicationComponent.class )
public interface ActivityComponent {

    void inject(EmailMenuImp emailMenuImp);
    
}
