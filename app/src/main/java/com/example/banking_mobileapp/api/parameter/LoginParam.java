package com.example.banking_mobileapp.api.parameter;

import com.google.gson.annotations.SerializedName;

public class LoginParam {

    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    public LoginParam(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
