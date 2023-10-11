package com.example.banking_mobileapp.api.repository;


import com.example.banking_mobileapp.api.client.RetrofitClientInstance;
import com.example.banking_mobileapp.api.model.Balance;
import com.example.banking_mobileapp.api.response.IResponse;
import com.example.banking_mobileapp.api.service.ApiService;

import retrofit2.Call;

public class BalanceRepository {
    public void UserBalanceRepository(String token, IResponse<Balance> balanceResponse) {
        ApiService apiService = RetrofitClientInstance.getInstanceWithToken(token).create(ApiService.class);
        Call<Balance> balanceCall = apiService.getUserBalance();
        new Repository<Balance>().callRepository(balanceCall, balanceResponse);
    }
}
