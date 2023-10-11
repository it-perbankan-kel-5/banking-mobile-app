package com.example.banking_mobileapp.api;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.banking_mobileapp.api.model.User;
import com.example.banking_mobileapp.api.repository.UserRepository;
import com.example.banking_mobileapp.api.response.IResponse;

import java.util.LinkedHashMap;

public class UserViewModel extends ViewModel {
    private UserRepository userRepository;
    private MutableLiveData<LinkedHashMap<String, String>> response;
    private MutableLiveData<String> result;
    public UserViewModel() {
        userRepository = new UserRepository();
        response = new MutableLiveData<>();
        result = new MutableLiveData<>();
    }

    public void getUserProfile(String token) {
        userRepository.userRemote(token, new IResponse<User>() {
            @Override
            public void onResponse(User user) {
                result.postValue("SUCCESS");

                response.postValue(new LinkedHashMap<String, String>() {{
                    put("first_name", user.getFirstName());
                    put("last_name", user.getLastName());
                    put("email", user.getEmail());
                    put("phone_number", user.getPhoneNumber());
                    put("address", user.getAddress());
                }});
            }

            @Override
            public void onFailure(Throwable t) {
                result.postValue("FAILED: " + t.getLocalizedMessage());
            }
        });
    }

    public LiveData<LinkedHashMap<String, String>> getResponse() {
        return response;
    }

    public LiveData<String> getResult() {
        return result;
    }
}
