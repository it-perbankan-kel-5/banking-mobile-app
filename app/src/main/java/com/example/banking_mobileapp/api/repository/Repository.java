package com.example.banking_mobileapp.api.repository;

import android.util.Log;

import com.example.banking_mobileapp.api.response.IResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository<T> {
    public void callRepository(Call<T> call, IResponse<T> iResponse) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.isSuccessful()){
                    iResponse.onResponse(response.body());
                } else {
                    iResponse.onFailure(new Throwable(response.toString()));
                }
                Log.d("Repository-Call", "Server Response: " + response);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                iResponse.onFailure(t);
            }
        });
    }
}
