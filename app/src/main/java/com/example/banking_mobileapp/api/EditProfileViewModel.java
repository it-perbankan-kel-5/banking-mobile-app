package com.example.banking_mobileapp.api;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.banking_mobileapp.api.model.EditProfile;
import com.example.banking_mobileapp.api.parameter.EditProfileParam;
import com.example.banking_mobileapp.api.repository.EditProfileRepository;
import com.example.banking_mobileapp.api.response.IResponse;

public class EditProfileViewModel extends ViewModel {
    private final EditProfileRepository editProfileRepository;
    private MutableLiveData<Boolean> status;

    private MutableLiveData<String> response;
    public EditProfileViewModel() {
        editProfileRepository = new EditProfileRepository();
        response = new MutableLiveData<>();
        status = new MutableLiveData<>();
    }

    public void editProfile(String token, String fristName,
                            String lastName, String phoneNumber, String address) {
        editProfileRepository.editProfileRepository(token,
                new EditProfileParam(fristName, lastName, phoneNumber, address),
                new IResponse<EditProfile>(){
            @Override
            public void onResponse(EditProfile editProfile) {
                response.postValue(editProfile.getMessage());
                status.postValue(Boolean.TRUE);
            }

            @Override
            public void onFailure(Throwable t) {
                response.postValue("Failed: " + t.toString());
                status.postValue(Boolean.TRUE);
            }
        });
    }

    public LiveData<String> getResponse() {
        return response;
    }

    public LiveData<Boolean> getStatus() {
        return status;
    }
}
