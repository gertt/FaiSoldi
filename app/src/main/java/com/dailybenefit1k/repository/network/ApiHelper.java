package com.dailybenefit1k.repository.network;

import com.dailybenefit1k.repository.network.model.DataJson;
import com.dailybenefit1k.repository.network.model.request.FormModel;
import io.reactivex.Single;

public interface ApiHelper {

    Single<DataJson> registration(FormModel formModel);

}
