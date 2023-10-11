package com.example.banking_mobileapp.api.repository;

import com.example.banking_mobileapp.api.client.RetrofitClientInstance;
import com.example.banking_mobileapp.api.model.Login;
import com.example.banking_mobileapp.api.parameter.LoginParam;
import com.example.banking_mobileapp.api.response.IResponse;
import com.example.banking_mobileapp.api.service.ApiService;

import retrofit2.Call;

public class LoginRepository {
    public void loginRemote(LoginParam loginParam, IResponse<Login> loginResponse) {
        ApiService apiService = RetrofitClientInstance.getInstance().create(ApiService.class);
        Call<Login> initLogin = apiService.login(loginParam);
        new Repository<Login>().callRepository(initLogin, loginResponse);
    }
}
