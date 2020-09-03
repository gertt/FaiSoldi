package com.dailybenefit1k.di.component;

import com.dailybenefit1k.di.module.ActivityModule;
import com.dailybenefit1k.di.scope.PerActivity;
import com.dailybenefit1k.ui.email.EmailMenuImp;
import com.dailybenefit1k.ui.menu.FormMenuImpl;

import dagger.Component;


@PerActivity
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    void inject(EmailMenuImp emailMenuImp);

    void inject(FormMenuImpl formMenu);

}
