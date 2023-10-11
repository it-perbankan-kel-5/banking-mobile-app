package com.example.banking_mobileapp.api.model;

import com.google.gson.annotations.SerializedName;

public class Transfer {
    @SerializedName("status")
    private String status;
    @SerializedName("email_receiver")
    private String email_receiver;
    @SerializedName("transfer_amount")
    private String transfer_amount;

    public Transfer(String status, String email_receiver, String transfer_amount) {
        this.status = status;
        this.email_receiver = email_receiver;
        this.transfer_amount = transfer_amount;
    }

    public String getStatus() {
        return status;
    }

    public String getEmail_receiver() {
        return email_receiver;
    }

    public String getTransfer_amount() {
        return transfer_amount;
    }
}
