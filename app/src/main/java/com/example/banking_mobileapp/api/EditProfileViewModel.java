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
<<<<<<< HEAD
    private MutableLiveData<Boolean> status;
=======
>>>>>>> 595092a8f333b30686bee47dff7f704d430f1ed4
    private MutableLiveData<String> response;
    public EditProfileViewModel() {
        editProfileRepository = new EditProfileRepository();
        response = new MutableLiveData<>();
<<<<<<< HEAD
        status = new MutableLiveData<>();
=======
>>>>>>> 595092a8f333b30686bee47dff7f704d430f1ed4
    }

    public void editProfile(String token, String fristName,
                            String lastName, String phoneNumber, String address) {
        editProfileRepository.editProfileRepository(token,
                new EditProfileParam(fristName, lastName, phoneNumber, address),
                new IResponse<EditProfile>(){
            @Override
            public void onResponse(EditProfile editProfile) {
                response.postValue(editProfile.getMessage());
<<<<<<< HEAD
                status.postValue(Boolean.TRUE);
=======
>>>>>>> 595092a8f333b30686bee47dff7f704d430f1ed4
            }

            @Override
            public void onFailure(Throwable t) {
                response.postValue("Failed: " + t.toString());
<<<<<<< HEAD
                status.postValue(Boolean.TRUE);
=======
>>>>>>> 595092a8f333b30686bee47dff7f704d430f1ed4
            }
        });
    }

    public LiveData<String> getResponse() {
        return response;
    }
<<<<<<< HEAD

    public LiveData<Boolean> getStatus() {
        return status;
    }
=======
>>>>>>> 595092a8f333b30686bee47dff7f704d430f1ed4
}
