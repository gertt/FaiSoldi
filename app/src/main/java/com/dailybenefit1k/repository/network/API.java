package com.dailybenefit1k.repository.network;

import com.dailybenefit1k.repository.network.model.DataJson;


import java.util.List;

import  io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by gPrifti on 7/5/2018.
 */

public interface API {



    @GET("users")
    Single<DataJson> getUserDetails();

}
