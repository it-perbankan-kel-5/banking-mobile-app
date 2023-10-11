package com.example.banking_mobileapp.api.service;

import com.example.testmvmm.api.model.Balance;
import com.example.testmvmm.api.model.Login;
import com.example.testmvmm.api.model.Logout;
import com.example.testmvmm.api.parameter.LoginParam;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/api/login")
    Call<Login> login(@Body LoginParam loginParam);

    @POST("/api/logout")
    Call<Logout> logout();

    @GET("/api/user/balance")
    Call<Balance> getUserBalance();

}
