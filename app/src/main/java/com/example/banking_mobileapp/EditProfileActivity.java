package com.example.banking_mobileapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.banking_mobileapp.api.EditProfileViewModel;
import com.example.banking_mobileapp.api.UserViewModel;

public class EditProfileActivity extends AppCompatActivity {
    private EditText etFName, etLName, etPhoneNumber, etAddress;
    private Button btnSave;
    private EditProfileViewModel editProfileViewModel;
    private UserViewModel userViewModel;
    private String token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_nama);

        editProfileViewModel = new ViewModelProvider(this).get(EditProfileViewModel.class);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        etFName = findViewById(R.id.etFirstName);
        etLName = findViewById(R.id.etLastName);
        etPhoneNumber = findViewById(R.id.etEmail);
        etAddress = findViewById(R.id.etAddress);
        btnSave = findViewById(R.id.btn_submitname);

        try {
            token = getToken();
            Log.d("EditProfileActivity-Token", "Token: " + token);
        } catch (NullPointerException exception) {
            token = "null";
            Log.d("EditProfileActivity" + " Error", "onCreate (Error): " + exception.getMessage());
        }

        setEditText();

        editProfileViewModel.getResponse().observe(this, s -> {
            Log.d("EditProfileActivity-EditStatus", "Status: " + s);
        });

        editProfileViewModel.getStatus().observe(this, editProfileStatus -> {
            if (editProfileStatus) {
                Toast.makeText(this, "Update Profile Berhasil", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Update Profile Gagal", Toast.LENGTH_LONG).show();
            }
        });

        btnSave.setOnClickListener(v -> {
            String fname = etFName.getText().toString();
            String lastName = etLName.getText().toString();
            String address = etAddress.getText().toString();
            String phoneNumber = etPhoneNumber.getText().toString();

            editProfileViewModel.editProfile(token, fname, lastName, phoneNumber, address);
        });
    }

    private String getToken() {
        Bundle extras = getIntent().getExtras();

        if(extras == null)
            return null;

        return extras.getString("token");
    }

    private void setEditText() {
        userViewModel.getUserProfile(token);

        userViewModel.getResponse().observe(this, s -> {
            etFName.setText(s.get("first_name"));
            etLName.setText(s.get("last_name"));
            etPhoneNumber.setText(s.get("phone_number"));
            etAddress.setText(s.get("address"));
        });
    }


}
