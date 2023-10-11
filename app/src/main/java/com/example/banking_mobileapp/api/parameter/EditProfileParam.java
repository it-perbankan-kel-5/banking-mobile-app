package com.example.banking_mobileapp.api.parameter;

import com.google.gson.annotations.SerializedName;

public class EditProfileParam {
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("address")
    private String address;

    public EditProfileParam(String firstName, String lastName, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
