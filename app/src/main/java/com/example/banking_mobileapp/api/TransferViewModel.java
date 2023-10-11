package com.example.banking_mobileapp.api;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.banking_mobileapp.api.model.Transfer;
import com.example.banking_mobileapp.api.parameter.TransferParam;
import com.example.banking_mobileapp.api.repository.TransferRepository;
import com.example.banking_mobileapp.api.response.IResponse;

import java.util.LinkedHashMap;

public class TransferViewModel extends ViewModel {

    private final MutableLiveData<LinkedHashMap<String, String>> response = new MutableLiveData<>();
    private final MutableLiveData<String> result = new MutableLiveData<>();
    private final MutableLiveData<Boolean> transferStatus = new MutableLiveData<>();
    private final TransferRepository transferRepository;

    public TransferViewModel() {
        transferRepository = new TransferRepository();
    }

    public void transfer(String email, String transferAmount, String userPin, String token) {
        transferRepository.transferRepository(token, new TransferParam(email, transferAmount, userPin), new IResponse<Transfer>() {
            @Override
            public void onResponse(Transfer transfer) {
                result.postValue("Success");
                LinkedHashMap<String, String> data = new LinkedHashMap<>();

                data.put("STATUS", transfer.getStatus());
                data.put("EMAIL_RECEIVER", transfer.getEmail_receiver());
                data.put("TRANSFER_AMOUNT", transfer.getTransfer_amount());

                response.postValue(data);
                transferStatus.postValue(Boolean.TRUE);
            }

            @Override
            public void onFailure(Throwable t) {
                result.postValue("Failed: " + t.getLocalizedMessage());
                transferStatus.postValue(Boolean.FALSE);
            }
        });
    }

    public LiveData<LinkedHashMap<String, String>> getResponse() {
        return response;
    }

    public LiveData<String> getResult() {
        return result;
    }

    public LiveData<Boolean> getTransferStatus() {
        return transferStatus;
    }
}
