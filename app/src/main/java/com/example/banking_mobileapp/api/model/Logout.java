package com.example.testmvmm.api.model;

import com.google.gson.annotations.SerializedName;

public class Logout {

    @SerializedName("message")
    private String message;

    public Logout(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
