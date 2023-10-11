package com.example.banking_mobileapp.api.response;

public interface IResponse<T> {
    void onResponse(T t);
    void onFailure(Throwable t);
}
