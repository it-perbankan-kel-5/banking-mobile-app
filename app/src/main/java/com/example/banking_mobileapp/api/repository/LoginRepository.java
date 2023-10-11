package com.example.testmvmm.api.repository;

import com.example.testmvmm.api.parameter.LoginParam;
import com.example.testmvmm.api.response.IResponse;
import com.example.testmvmm.api.service.ApiService;
import com.example.testmvmm.api.client.RetrofitClientInstance;
import com.example.testmvmm.api.model.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository<T> {
    public void loginRemote(LoginParam loginParam, IResponse<Login> loginResponse) {
        ApiService apiService = RetrofitClientInstance.getInstance().create(ApiService.class);
        Call<Login> initLogin = apiService.login(loginParam);

        initLogin.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.isSuccessful()){
                    loginResponse.onResponse(response.body());
                } else {
                    loginResponse.onFailure(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                loginResponse.onFailure(t);
            }
        });
    }
}
