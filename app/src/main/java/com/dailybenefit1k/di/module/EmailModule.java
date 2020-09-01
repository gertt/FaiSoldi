package com.dailybenefit1k.di.module;

import com.dailybenefit1k.ui.base.BaseActivity;
import com.dailybenefit1k.ui.email.EmailMenu;
import com.dailybenefit1k.ui.email.EmailMenuPreImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class EmailModule {

    private BaseActivity baseActivity;

    public EmailModule(BaseActivity baseActivity){
        this.baseActivity = baseActivity;
    }

    @Provides
    static EmailMenu.Presenter provideEmailMenuPresenter(EmailMenuPreImpl<EmailMenu.View> emailMenuPreImpl){
        return emailMenuPreImpl;
    }
}
