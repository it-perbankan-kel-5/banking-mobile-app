package com.example.banking_mobileapp.api.repository;

import com.example.banking_mobileapp.api.client.RetrofitClientInstance;
import com.example.banking_mobileapp.api.model.EditProfile;
import com.example.banking_mobileapp.api.parameter.EditProfileParam;
import com.example.banking_mobileapp.api.response.IResponse;
import com.example.banking_mobileapp.api.service.ApiService;

import retrofit2.Call;

public class EditProfileRepository {
    public void editProfileRepository(
            String token, EditProfileParam editProfileParam,
            IResponse<EditProfile> iResponse) {
        ApiService apiService = RetrofitClientInstance.getInstanceWithToken(token).create(ApiService.class);
        Call<EditProfile> editProfileCall = apiService.editProfile(editProfileParam);

        new Repository<EditProfile>().callRepository(editProfileCall, iResponse);
    }
}
