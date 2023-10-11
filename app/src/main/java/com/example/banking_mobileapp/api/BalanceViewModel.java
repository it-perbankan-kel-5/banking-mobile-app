package com.example.banking_mobileapp.api;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testmvmm.api.model.Balance;
import com.example.testmvmm.api.repository.BalanceRepository;
import com.example.testmvmm.api.response.IResponse;

import java.util.LinkedHashMap;

public class BalanceViewModel extends ViewModel {
    private final MutableLiveData<LinkedHashMap<String, String>> mUserBalanceResponseMutableData = new MutableLiveData<>();
    private final BalanceRepository balanceRepository;

    public BalanceViewModel() {
        this.balanceRepository = new BalanceRepository();
    }

    public void getUserBalanceDetails(String token) {
        balanceRepository.UserBalanceRepository(token, new IResponse<Balance>() {
            @Override
            public void onResponse(Balance balance) {
                LinkedHashMap<String, String> response = new LinkedHashMap<>();

                response.put("fname", balance.getFirst_name());
                response.put("lname", balance.getLast_name());
                response.put("email", balance.getEmail());
                response.put("card_number", balance.getCard_number());
                response.put("balance", balance.getBalance());
                response.put("income", balance.getIncome());
                response.put("outcome", balance.getOutcome());

                mUserBalanceResponseMutableData.postValue(response);
            }

            @Override
            public void onFailure(Throwable t) {
                mUserBalanceResponseMutableData.postValue(null);
            }
        });
    }

    public LiveData<LinkedHashMap<String, String>> getResponse() {
        return mUserBalanceResponseMutableData;
    }
}
