package com.dailybenefit1k.di.component;

import com.dailybenefit1k.di.module.EmailModule;
import com.dailybenefit1k.di.scope.PerActivity;
import com.dailybenefit1k.ui.email.EmailMenuImp;

import dagger.Component;


@PerActivity
@Component(modules = EmailModule.class ,dependencies = ApplicationComponent.class )
public interface ActivityComponent {

    void inject(EmailMenuImp emailMenuImp);

}
