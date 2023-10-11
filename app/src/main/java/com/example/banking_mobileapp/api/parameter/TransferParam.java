package com.example.banking_mobileapp.api.parameter;

import com.google.gson.annotations.SerializedName;

public class TransferParam {
    @SerializedName("email")
    private String email;
    @SerializedName("transfer_amount")
    private String transferAmount;
    @SerializedName("pin")
    private String userPin;

    public TransferParam(String email, String transferAmount, String userPin) {
        this.email = email;
        this.transferAmount = transferAmount;
        this.userPin = userPin;
    }
}
