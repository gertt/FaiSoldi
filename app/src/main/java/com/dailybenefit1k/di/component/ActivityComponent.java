package com.dailybenefit1k.di.component;


import com.dailybenefit1k.di.module.EmailModule;
import com.dailybenefit1k.ui.email.EmailMenuImp;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {EmailModule.class}, dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    void inject(EmailMenuImp emailMenuImp);
}
