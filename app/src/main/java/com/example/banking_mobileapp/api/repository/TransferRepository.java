package com.example.banking_mobileapp.api.repository;

import com.example.banking_mobileapp.api.client.RetrofitClientInstance;
import com.example.banking_mobileapp.api.model.Transfer;
import com.example.banking_mobileapp.api.parameter.TransferParam;
import com.example.banking_mobileapp.api.response.IResponse;
import com.example.banking_mobileapp.api.service.ApiService;

import retrofit2.Call;

public class TransferRepository {
    public void transferRepository(String token, TransferParam transferParam, IResponse<Transfer> iResponse) {
        ApiService apiService = RetrofitClientInstance.getInstanceWithToken(token).create(ApiService.class);
        Call<Transfer> transferCall = apiService.transfer(transferParam);

        new Repository<Transfer>().callRepository(transferCall, iResponse);
    }
}
