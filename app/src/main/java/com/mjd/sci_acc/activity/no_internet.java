package com.mjd.sci_acc.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mjd.sci_acc.MainActivity;
import com.mjd.sci_acc.R;

public class no_internet extends AppCompatActivity {
    Button retry_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no_internet);
        retry_btn = findViewById(R.id.retry_btn);
        retry_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                isOnline();

            }
        });

    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            Toast.makeText(this, "Enjoy you are connected :) ✨", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(this, MainActivity.class));

            return true;

        } else {
            startActivity(new Intent(this, no_internet.class));
            Toast.makeText(this, "You still dont have internet Connection :(", Toast.LENGTH_SHORT).show();
            return false;
        }


    }
}
