package com.example.banking_mobileapp.api;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.banking_mobileapp.api.model.Logout;
import com.example.banking_mobileapp.api.repository.LogoutRepository;
import com.example.banking_mobileapp.api.response.IResponse;

public class LogoutViewModel extends ViewModel {
    private final MutableLiveData<String> mLogoutResultMutableData = new MutableLiveData<>();
    private final MutableLiveData<String> mLogoutResponseMutableData = new MutableLiveData<>();
    private final LogoutRepository logoutRepository;

    public LogoutViewModel() {
        this.logoutRepository = new LogoutRepository();
    }

    public void logout(String token) {
        logoutRepository.logoutRemote(token, new IResponse<Logout>() {
            @Override
            public void onResponse(Logout logout) {
                mLogoutResultMutableData.postValue("Logout Success");
                mLogoutResponseMutableData.postValue(logout.getMessage());
            }

            @Override
            public void onFailure(Throwable t) {
                mLogoutResultMutableData.postValue("Logoout Failed: " + t.getMessage());
            }
        });
    }

    public LiveData<String> getLogoutResult() {
        return mLogoutResultMutableData;
    }

    public LiveData<String> getLogoutResponse() {
        return mLogoutResponseMutableData;
    }
}
