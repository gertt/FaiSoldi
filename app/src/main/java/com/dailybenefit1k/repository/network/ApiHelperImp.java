package com.dailybenefit1k.repository.network;

import com.dailybenefit1k.repository.network.model.DataJson;
import com.dailybenefit1k.repository.network.model.request.FormModel;

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
    public Single<DataJson> registration(FormModel formModel) {
        return api.getRegistrationResponse(formModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(userInfo -> {})
                .doOnError(userInfo ->{});
    }

}
