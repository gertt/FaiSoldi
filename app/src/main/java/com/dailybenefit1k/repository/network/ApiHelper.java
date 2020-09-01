package com.dailybenefit1k.repository.network;


import com.dailybenefit1k.repository.network.model.DataJson;

import io.reactivex.Single;


public interface ApiHelper {

    Single<DataJson> getssData();
}
