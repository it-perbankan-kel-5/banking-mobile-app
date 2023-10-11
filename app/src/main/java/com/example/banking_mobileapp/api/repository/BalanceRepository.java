package com.example.banking_mobileapp.api.repository;

import com.example.testmvmm.api.client.RetrofitClientInstance;
import com.example.testmvmm.api.model.Logout;
import com.example.testmvmm.api.response.IResponse;
import com.example.testmvmm.api.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BalanceRepository {
    public void UserBalanceRepository(String token, IResponse balanceResponse) {
        ApiService apiService = RetrofitClientInstance.getInstanceWithToken(token).create(ApiService.class);
        Call<Logout> callLogout = apiService.logout();

        callLogout.enqueue(new Callback<Logout>() {
            @Override
            public void onResponse(Call<Logout> call, Response<Logout> response) {
                if (response.isSuccessful()){
                    balanceResponse.onResponse(response.body());
                } else {
                    balanceResponse.onFailure(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<Logout> call, Throwable t) {
                balanceResponse.onFailure(t);
            }
        });
    }
}
