package com.example.banking_mobileapp.api.model;

import com.google.gson.annotations.SerializedName;

public class EditProfile {
    @SerializedName("message")
    private String message;

    public EditProfile(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
