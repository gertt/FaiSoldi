package com.dailybenefit1k.di.module;

import com.dailybenefit1k.ui.base.BaseActivity;
import com.dailybenefit1k.ui.email.EmailMenu;
import com.dailybenefit1k.ui.email.EmailMenuPreImpl;
import com.dailybenefit1k.ui.menu.FormMenu;
import com.dailybenefit1k.ui.menu.FormMenuPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private BaseActivity baseActivity;

    public ActivityModule(BaseActivity baseActivity){
        this.baseActivity = baseActivity;
    }

    @Provides
    static EmailMenu.Presenter provideEmailMenuPresenter(EmailMenuPreImpl<EmailMenu.View> emailMenuPreImpl){
        return emailMenuPreImpl;
    }

    @Provides
    static FormMenu.Presenter provideFormMenuPresenter(FormMenuPresenterImpl<FormMenu.View> formMenuPresenter){
        return formMenuPresenter;
    }
}
