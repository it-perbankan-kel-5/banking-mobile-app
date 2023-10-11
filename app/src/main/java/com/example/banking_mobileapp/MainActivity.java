package com.example.banking_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
    }

    public void toMenu(View view) {
        Intent login = new Intent(MainActivity.this, MainActivity.class);
        startActivity(login);
    }

   }