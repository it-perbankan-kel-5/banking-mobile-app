package com.example.testmvmm.api;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;

import com.example.testmvmm.api.model.Logout;
import com.example.testmvmm.api.repository.LogoutRepository;
import com.example.testmvmm.api.response.IResponse;

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
