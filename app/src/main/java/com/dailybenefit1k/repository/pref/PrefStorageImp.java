package com.dailybenefit1k.repository.pref;

import android.content.Context;
import android.content.SharedPreferences;
import com.dailybenefit1k.di.scope.ApplicationContext;
import com.dailybenefit1k.di.scope.PreferenceInfo;
import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class PrefStorageImp implements PrefStorage {

    Context ctx;
    SharedPreferences mPrefs;

    private static final String PREF_KEY_EMAIL = "PREF_KEY_EMAIL";

    @Inject
    public PrefStorageImp(@ApplicationContext Context ctx1, @PreferenceInfo  String prefFileName) {
        this.ctx = ctx1;
        mPrefs = ctx1.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public void saveEmail(String email) {
        mPrefs.edit().putString(PREF_KEY_EMAIL, email).apply();
    }

    @Override
    public String getEmail() {
        return mPrefs.getString(PREF_KEY_EMAIL, "");
    }
}
