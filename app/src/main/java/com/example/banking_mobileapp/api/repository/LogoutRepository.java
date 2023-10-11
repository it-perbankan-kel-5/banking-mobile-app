package com.example.banking_mobileapp.api.repository;

import com.example.banking_mobileapp.api.client.RetrofitClientInstance;
import com.example.banking_mobileapp.api.model.Logout;
import com.example.banking_mobileapp.api.response.IResponse;
import com.example.banking_mobileapp.api.service.ApiService;

import retrofit2.Call;

public class LogoutRepository {
    public void logoutRemote(String token, IResponse<Logout> logoutIResponse) {
        ApiService apiService = RetrofitClientInstance.getInstanceWithToken(token).create(ApiService.class);
        Call<Logout> callLogout = apiService.logout();
        new Repository<Logout>().callRepository(callLogout, logoutIResponse);
    }
}
