package com.example.testmvmm.api.client;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpClientInstance {
    private static OkHttpClient client;

    public static OkHttpClient getInstance(String token) {
        if (client == null)
            client = new OkHttpClient.Builder().addInterceptor(chain -> {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Authorization", "Bearer " + token)
                        .build();
                return chain.proceed(newRequest);
            }).build();

        return client;
    }
}
