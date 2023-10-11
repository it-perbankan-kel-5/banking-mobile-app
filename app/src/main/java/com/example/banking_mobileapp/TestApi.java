package com.example.banking_mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.banking_mobileapp.api.BalanceViewModel;
import com.example.banking_mobileapp.api.LoginViewModel;
import com.example.banking_mobileapp.api.LogoutViewModel;
import com.example.banking_mobileapp.api.UserViewModel;
import com.example.banking_mobileapp.api.test.EditProfileActivity;
import com.example.banking_mobileapp.api.test.TransferActivity;

import java.util.ArrayList;
import java.util.Objects;

public class TestApi extends AppCompatActivity {

    private EditText txtEmail, txtPassword;
    private Button btnLogin, btnLogout, btnProcess, btnProfile, btnEditProfile, btnTransfer;
    private LoginViewModel loginViewModel;
    private LogoutViewModel logoutViewModel;
    private BalanceViewModel balanceViewModel;
    private UserViewModel userViewModel;
    private String token;
    private ArrayList<String> userData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_api);

        txtEmail = findViewById(R.id.editTextTextEmailAddress);
        txtPassword = findViewById(R.id.editTextTextPassword);
        btnLogin = findViewById(R.id.login);
        btnLogout = findViewById(R.id.logout);
        btnProcess = findViewById(R.id.process);
        btnProfile = findViewById(R.id.profile);
        btnEditProfile = findViewById(R.id.editProfile);
        btnTransfer = findViewById(R.id.transfer);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        logoutViewModel = new ViewModelProvider(this).get(LogoutViewModel.class);
        balanceViewModel = new ViewModelProvider(this).get(BalanceViewModel.class);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        userData = new ArrayList<>();

        login();
        getUserBalanceDetail();
        getUserProfile();
        logout();

        btnEditProfile.setOnClickListener(v -> {
            Intent intent = new Intent(this, EditProfileActivity.class);
            intent.putExtra("token", token);
            intent.putStringArrayListExtra("user", userData);
            startActivity(intent);
        });

        btnTransfer.setOnClickListener(v -> {
            Intent intent = new Intent(this, TransferActivity.class);
            intent.putExtra("token", token);
            startActivity(intent);
        });
    }

    public void login() {
        loginViewModel.getLoginResult().observe(this, s -> {
            Log.d("LOGIN_STATUS", s);
        });

        loginViewModel.getLoginResponse().observe(this, s -> {
            token = Objects.requireNonNull(s.get("TOKEN"));
            Log.d("LOGIN_RESPONSE_MESSAGE", Objects.requireNonNull(s.get("MESSAGE")));
            Log.d("LOGIN_RESPONSE_ID", Objects.requireNonNull(s.get("ID")));
            Log.d("LOGIN_RESPONSE_TOKEN", token);
        });

        btnLogin.setOnClickListener(view ->
                loginViewModel.login(
                        txtEmail.getText().toString(),
                        txtPassword.getText().toString()));
    }

    public void logout() {
        logoutViewModel.getLogoutResult().observe(this, s -> {
            Log.d("LOGOUT_STATUS", "STATUS: " + s);
        });

        btnLogout.setOnClickListener(view -> {
            logoutViewModel.logout(token);
        });
    }

    public void getUserBalanceDetail() {
        balanceViewModel.getResponse().observe(this, s -> {
            s.forEach((k, v) -> {
                Log.d("DATA_"+k, "RESP: " + v);
            });
        });

        btnProcess.setOnClickListener(v -> {
            balanceViewModel.getUserBalanceDetails(token);
        });
    }

    public void getUserProfile() {
        userViewModel.getResult().observe(this, s -> {
            Log.d("API_RESPONSE", "RESP: " + s);
        });

        userViewModel.getResponse().observe(this, s -> {
            s.forEach((k, v) -> {
                userData.add(v);
                Log.d("DATA_"+k, "RESP: " + v);
            });
        });


        btnProfile.setOnClickListener(v -> {
            userViewModel.getUserProfile(token);
        });
    }
}