package com.pratyaksh.ramcabs.API;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("sendotp")
    Call<DataModel> sendOTP(@Body String number);
}
