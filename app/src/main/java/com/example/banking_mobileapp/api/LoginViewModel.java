package com.example.banking_mobileapp.api;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.banking_mobileapp.api.model.Login;
import com.example.banking_mobileapp.api.parameter.LoginParam;
import com.example.banking_mobileapp.api.repository.LoginRepository;
import com.example.banking_mobileapp.api.response.IResponse;

import java.util.LinkedHashMap;

public class LoginViewModel extends ViewModel {
    private final MutableLiveData<String> mLoginResultMutableData = new MutableLiveData<>();
<<<<<<< HEAD
    private final MutableLiveData<Boolean> isLoggin = new MutableLiveData<>();
=======
>>>>>>> 595092a8f333b30686bee47dff7f704d430f1ed4
    private final MutableLiveData<LinkedHashMap<String, String>> mLoginResponseMutableData = new MutableLiveData<>();
    private final LoginRepository loginRepository;

    public LoginViewModel() {
        loginRepository = new LoginRepository();
    }

    public void login(String email, String password) {
        mLoginResultMutableData.postValue("Checking");
        loginRepository.loginRemote(new LoginParam(email, password), new IResponse<Login>() {
            @Override
            public void onResponse(Login loginResponse) {
                mLoginResultMutableData.postValue("Login Success");
<<<<<<< HEAD
=======

>>>>>>> 595092a8f333b30686bee47dff7f704d430f1ed4
                LinkedHashMap<String, String> responses = new LinkedHashMap<>();

                responses.put("ID", loginResponse.getId());
                responses.put("TOKEN", loginResponse.getToken());
                responses.put("MESSAGE", loginResponse.getMessage());

                mLoginResponseMutableData.postValue(responses);
<<<<<<< HEAD
                isLoggin.postValue(Boolean.TRUE);
=======
>>>>>>> 595092a8f333b30686bee47dff7f704d430f1ed4
            }

            @Override
            public void onFailure(Throwable t) {
<<<<<<< HEAD
                isLoggin.postValue(Boolean.FALSE);
=======
>>>>>>> 595092a8f333b30686bee47dff7f704d430f1ed4
                mLoginResultMutableData.postValue("Login Failed: " + t.getMessage());
            }
        });
    }

    public LiveData<String> getLoginResult(){
        return mLoginResultMutableData;
    }
    public LiveData<LinkedHashMap<String, String>> getLoginResponse() {
        return mLoginResponseMutableData;
    }
<<<<<<< HEAD

    public LiveData<Boolean> getLoginStatus() {
        return isLoggin;
    }
=======
>>>>>>> 595092a8f333b30686bee47dff7f704d430f1ed4
}
