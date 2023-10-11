package com.example.testmvmm.api.response;

public interface IResponse<T> {
    void onResponse(T t);
    void onFailure(Throwable t);
}
