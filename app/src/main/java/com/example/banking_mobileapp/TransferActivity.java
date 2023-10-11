package com.example.banking_mobileapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.banking_mobileapp.api.TransferViewModel;

public class TransferActivity extends AppCompatActivity {
    private String token;
    private TransferViewModel transferViewModel;
    private EditText etReceiver, etTransferAmount, etPin;
    private Button btnTranser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        transferViewModel = new ViewModelProvider(this).get(TransferViewModel.class);

        etReceiver = findViewById(R.id.receiver);
        etTransferAmount = findViewById(R.id.jumlah);
        etPin = findViewById(R.id.pin);
        btnTranser = findViewById(R.id.btn_transfer);

        etReceiver.setText("zulauf.phyllis@example.com");
        etTransferAmount.setText("123456");
        etPin.setText("906503");

        try {
            token = getToken();
            Log.d("EditProfileActivity-Token", "Token: " + token);
        } catch (NullPointerException exception) {
            token = "null";
            Log.d("EditProfileActivity" + " Error", "onCreate (Error): " + exception.getMessage());
        }

        btnTranser.setOnClickListener(v -> {
            String receiver = etReceiver.getText().toString();
            String amount = etTransferAmount.getText().toString();
            String pin = etPin.getText().toString();

            transferViewModel.transfer(receiver, amount, pin, token);
        });

        transferViewModel.getResult().observe(this, s -> {
            Log.d("Transfer-Result", "Result: " + s);
        });

        transferViewModel.getTransferStatus().observe(this, statusTransfer -> {
            if(statusTransfer) {
                Toast.makeText(this, "Transfer Berhasil", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Transfer Gagal", Toast.LENGTH_LONG).show();
            }
        });
    }

    private String getToken() {
        Bundle extras = getIntent().getExtras();

        if(extras == null)
            return null;

        return extras.getString("token");
    }
}
