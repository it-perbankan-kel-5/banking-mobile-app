package com.example.banking_mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.banking_mobileapp.api.BalanceViewModel;
import com.example.banking_mobileapp.api.LoginViewModel;
import com.example.banking_mobileapp.api.LogoutViewModel;

import java.util.Objects;

public class TestApi extends AppCompatActivity {

    private EditText txtEmail, txtPassword;
    private Button btnLogin, btnLogout, btnProcess;
    private LoginViewModel loginViewModel;
    private LogoutViewModel logoutViewModel;
    private BalanceViewModel balanceViewModel;
    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_api);

        txtEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        txtPassword = (EditText) findViewById(R.id.editTextTextPassword);
        btnLogin = (Button) findViewById(R.id.login);
        btnLogout = (Button) findViewById(R.id.logout);
        btnProcess = (Button) findViewById(R.id.process);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        logoutViewModel = new ViewModelProvider(this).get(LogoutViewModel.class);
        balanceViewModel = new ViewModelProvider(this).get(BalanceViewModel.class);
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

    public void proccedUserBalanceDetails() {
        balanceViewModel.getResponse().observe(this, s -> {
            s.forEach((k, v) -> {
                Log.d("BALANCE_RESPONSE_"+k, "RESP: " + v);
            });
        });

        btnProcess.setOnClickListener(v -> {
            balanceViewModel.getUserBalanceDetails(token);
        });
    }
}