package com.example.banking_mobileapp.api.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.banking_mobileapp.R;
import com.example.banking_mobileapp.api.EditProfileViewModel;
import com.example.banking_mobileapp.api.UserViewModel;

import java.util.ArrayList;
import java.util.Objects;

public class EditProfileActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etPhoneNumber, etAddress;
    private Button btnSave;
    private EditProfileViewModel editProfileViewModel;
    private UserViewModel userViewModel;
    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editProfileViewModel = new EditProfileViewModel();
        userViewModel = new UserViewModel();

        etFirstName = findViewById(R.id.editTextFirstName);
        etLastName = findViewById(R.id.editTextLastName);
        etPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        etAddress = findViewById(R.id.editTextAddress);
        btnSave = findViewById(R.id.btnSaveProfile);

        try {
            token = getToken();
<<<<<<< HEAD
            Log.d("EditProfileActivity-Token", "Token: " + token);
        } catch (NullPointerException exception) {
            token = "null";
            Log.d("EditProfileActivity" + " Error", "onCreate (Error): " + exception.getMessage());
=======
            Log.d("EditProfile-Token", "Token: " + token);
        } catch (NullPointerException exception) {
            token = "null";
            Log.d("EditProfile" + " Error", "onCreate (Error): " + exception.getMessage());
>>>>>>> 595092a8f333b30686bee47dff7f704d430f1ed4
        }

        setEditText();

        editProfileViewModel.getResponse().observe(this, s -> {
<<<<<<< HEAD
            Log.d("EditProfileActivity-EditStatus", "Status: " + s);
=======
            Log.d("EditProfile-EditStatus", "Status: " + s);
>>>>>>> 595092a8f333b30686bee47dff7f704d430f1ed4
        });

        btnSave.setOnClickListener(v -> {
            String fname = etFirstName.getText().toString();
            String lastName = etLastName.getText().toString();
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
            etFirstName.setText(s.get("first_name"));
            etLastName.setText(s.get("last_name"));
            etPhoneNumber.setText(s.get("phone_number"));
            etAddress.setText(s.get("address"));
        });
    }
}