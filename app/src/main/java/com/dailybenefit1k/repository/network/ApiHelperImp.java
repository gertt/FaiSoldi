package com.dailybenefit1k.repository.network;

import com.dailybenefit1k.repository.network.model.DataJson;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class ApiHelperImp implements  ApiHelper {

    API api;

    @Inject
    public ApiHelperImp(API api) {
        this.api = api;
    }

    @Override
    public Single<DataJson> doCall() {
        return api.getUserDetails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(userInfo -> {})
                .doOnError(userInfo ->{});
    }
}
