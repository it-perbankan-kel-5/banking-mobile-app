package com.example.banking_mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.banking_mobileapp.api.LoginViewModel;
import com.example.banking_mobileapp.api.test.EditProfileActivity;

import java.util.Objects;

public class LoginFragment extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private LoginViewModel loginViewModel;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        etEmail = findViewById(R.id.editTextLoginEmail);
        etPassword = findViewById(R.id.editTextLoginPasswod);
        btnLogin = findViewById(R.id.btnLogin);

        etEmail.setText("bernadette.predovic@example.net");
        etPassword.setText("906503");

        btnLogin.setOnClickListener(v -> {
            loginViewModel.login(etEmail.getText().toString(), etPassword.getText().toString());
        });

        loginViewModel.getLoginResponse().observe(this, s -> {
            token = Objects.requireNonNull(s.get("TOKEN"));
        });

        loginViewModel.getLoginStatus().observe(this, loggin -> {
            if (loggin) {
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_LONG).show();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Intent intent = new Intent(this, ProfileActivity.class);
                intent.putExtra("token", token);
                startActivity(intent);
            }
        });
    }

}