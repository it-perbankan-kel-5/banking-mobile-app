package com.example.banking_mobileapp.api.model;

import com.google.gson.annotations.SerializedName;

public class Balance {
    @SerializedName("fname")
    private String first_name;
    @SerializedName("lname")
    private String last_name;
    @SerializedName("email")
    private String email;
    @SerializedName("card_number")
    private String card_number;
    @SerializedName("balance")
    private String balance;
    @SerializedName("income")
    private String income;
    @SerializedName("outcome")
    private String outcome;

    public Balance(String first_name, String last_name, String email, String card_number, String balance, String income, String outcome) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.card_number = card_number;
        this.balance = balance;
        this.income = income;
        this.outcome = outcome;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
}
