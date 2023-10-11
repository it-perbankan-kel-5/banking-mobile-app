package com.example.banking_mobileapp.api.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.banking_mobileapp.R;
import com.example.banking_mobileapp.api.TransferViewModel;

public class TransferActivity extends AppCompatActivity {

    private EditText etEmailReceiver, etTransferAmount, etUserPin;
    private Button btnTransfer;
    private TransferViewModel transferViewModel;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasfer);

        etEmailReceiver = findViewById(R.id.editTextEmailReceiver);
        etTransferAmount = findViewById(R.id.editTextTransferAmount);
        etUserPin = findViewById(R.id.editTextPin);
        btnTransfer = findViewById(R.id.btnTransfer);

        etEmailReceiver.setText("zulauf.phyllis@example.com");
        etUserPin.setText("906503");
        etTransferAmount.setText("161616");

        transferViewModel = new ViewModelProvider(this).get(TransferViewModel.class);

        try {
            token = getToken();
            Log.d("EditProfileActivity-Token", "Token: " + token);
        } catch (NullPointerException exception) {
            token = "null";
            Log.d("EditProfileActivity" + " Error", "onCreate (Error): " + exception.getMessage());
        }

        transferViewModel.getResponse().observe(this, s -> {
            s.forEach((k, v) -> {
                Log.d("TransferResponse", "Data: " + v);
            });
        });

        transferViewModel.getResult().observe(this, s -> {
            Log.d("TransferResult", "Status: " + s);
        });

        btnTransfer.setOnClickListener(v -> {
            String email = etEmailReceiver.getText().toString();
            String transfer = etTransferAmount.getText().toString();
            String pin = etUserPin.getText().toString();

            transferViewModel.transfer(email, transfer, pin, token);
        });
    }

    private String getToken() {
        Bundle extras = getIntent().getExtras();

        if(extras == null)
            return null;

        return extras.getString("token");
    }

}