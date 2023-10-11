package com.example.testmvmm.api.model;

import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("token")
    private String token;

    @SerializedName("id")
    private String id;

    @SerializedName("message")
    private String message;

    public Login(String token, String id, String message) {
        this.token = token;
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return "Bearer " + token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
