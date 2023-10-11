package com.example.banking_mobileapp.api.service;

import com.example.banking_mobileapp.api.model.Balance;
import com.example.banking_mobileapp.api.model.EditProfile;
import com.example.banking_mobileapp.api.model.Login;
import com.example.banking_mobileapp.api.model.Logout;
import com.example.banking_mobileapp.api.model.Transfer;
import com.example.banking_mobileapp.api.model.User;
import com.example.banking_mobileapp.api.parameter.EditProfileParam;
import com.example.banking_mobileapp.api.parameter.LoginParam;
import com.example.banking_mobileapp.api.parameter.TransferParam;

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

    @GET("/api/user/profile")
    Call<User> getUserProfile();

    @POST("/api/transfer")
    Call<Transfer> transfer(@Body TransferParam transferParam);

    @POST("/api/user/profile/edit")
    Call<EditProfile> editProfile(@Body EditProfileParam editProfileParam);
}
