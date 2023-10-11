package com.example.banking_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class ProfileActivity extends AppCompatActivity {
    private String token;
    private Button btnEditProfile, btnTransfer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_nasabah);

        btnEditProfile = findViewById(R.id.btn_perbaruidata);
        btnTransfer = findViewById(R.id.btn_transfer);

        try {
            token = getToken();
            Log.d("EditProfileActivity-Token", "Token: " + token);
        } catch (NullPointerException exception) {
            token = "null";
            Log.d("EditProfileActivity" + " Error", "onCreate (Error): " + exception.getMessage());
        }

        btnEditProfile.setOnClickListener(v -> {
            Intent intent = new Intent(this, EditProfileActivity.class);
            intent.putExtra("token", token);
            startActivity(intent);
        });

        btnTransfer.setOnClickListener(v -> {
            Intent intent = new Intent(this, TransferActivity.class);
            intent.putExtra("token", token);
            startActivity(intent);
        });
    }

    private String getToken() {
        Bundle extras = getIntent().getExtras();

        if(extras == null)
            return null;

        return extras.getString("token");
    }
}
