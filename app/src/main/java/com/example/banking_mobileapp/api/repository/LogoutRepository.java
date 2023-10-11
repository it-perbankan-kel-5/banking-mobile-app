package com.example.banking_mobileapp.api.repository;

import com.example.banking_mobileapp.api.client.RetrofitClientInstance;
import com.example.banking_mobileapp.api.model.Logout;
import com.example.banking_mobileapp.api.response.IResponse;
import com.example.banking_mobileapp.api.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogoutRepository {
    public void logoutRemote(String token, IResponse<Logout> logoutIResponse) {
        ApiService apiService = RetrofitClientInstance.getInstanceWithToken(token).create(ApiService.class);
        Call<Logout> callLogout = apiService.logout();

        callLogout.enqueue(new Callback<Logout>() {
            @Override
            public void onResponse(Call<Logout> call, Response<Logout> response) {
                if (response.isSuccessful()){
                    logoutIResponse.onResponse(response.body());
                } else {
                    logoutIResponse.onFailure(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<Logout> call, Throwable t) {
                logoutIResponse.onFailure(t);
            }
        });
    }
}
