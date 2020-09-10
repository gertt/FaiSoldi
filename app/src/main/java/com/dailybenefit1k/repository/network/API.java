package com.dailybenefit1k.repository.network;

import com.dailybenefit1k.repository.network.model.DataJson;
import com.dailybenefit1k.repository.network.model.request.FormModel;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by gPrifti on 7/5/2018.
 */

public interface API {

    @POST("/rest2")
    Single<DataJson> getRegistrationResponse(@Body FormModel formModel);


}
