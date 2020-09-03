package com.dailybenefit1k.repository.network;

import com.dailybenefit1k.repository.network.model.DataJson;
import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by gPrifti on 7/5/2018.
 */

public interface API {

    @GET("/")
    Single<DataJson> getUserDetails();

}
