package com.example.testmvmm.api.repository;

import android.util.Log;

import com.example.testmvmm.api.response.IResponse;
import com.example.testmvmm.api.service.ApiService;
import com.example.testmvmm.api.client.RetrofitClientInstance;
import com.example.testmvmm.api.model.Logout;

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
