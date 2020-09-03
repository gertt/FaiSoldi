package com.dailybenefit1k.repository;

import com.dailybenefit1k.repository.network.ApiHelper;
import com.dailybenefit1k.repository.network.model.DataJson;
import com.dailybenefit1k.repository.pref.PrefStorage;
import javax.inject.Inject;
import io.reactivex.Single;

public class RepositoryImp implements Repository {

    private final  PrefStorage prefStorage;
    private final  ApiHelper apiHelper;

    @Inject
    public RepositoryImp(PrefStorage prefStorage , ApiHelper apiHelper) {
        this.prefStorage = prefStorage;
        this.apiHelper = apiHelper;
    }

    @Override
    public void saveEmail(String email) {
      prefStorage.saveEmail(email);
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public Single<DataJson> doCall() {
        return apiHelper.doCall();
    }
}
