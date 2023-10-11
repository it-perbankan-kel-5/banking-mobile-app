package com.example.testmvmm.api.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static Retrofit retrofitWithToken;
    private static final String BASE_URL = "https://silicious-apprehens.000webhostapp.com/";

    public static Retrofit getInstance() {
        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return retrofit;
    }

    public static Retrofit getInstanceWithToken(String token) {
        if (retrofitWithToken == null)
            retrofitWithToken = new Retrofit.Builder()
                    .client(OkHttpClientInstance.getInstance(token))
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return retrofitWithToken;
    }


}
