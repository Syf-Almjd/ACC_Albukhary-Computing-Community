package com.mjd.sci_acc;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mjd.sci_acc.activity.StartAnimation.MainScreen;
import com.mjd.sci_acc.activity.fragmentStart;
import com.mjd.sci_acc.activity.no_internet;

public class MainActivity extends AppCompatActivity {
    private static FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onStart() {
        super.onStart();
//         Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            Toast.makeText(this, "AI says: Welcome back! :)", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, fragmentStart.class));
        } else {
            Toast.makeText(this, "Inspired and Developed in 🇲🇾\nwith love from 🇵🇸", Toast.LENGTH_SHORT).show();
            startActivity(MainScreen.newIntent(this, true, true));
        }
        isOnline();
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            finish();
            startActivity(new Intent(this, no_internet.class));
            Toast.makeText(this, "You have no internet Connection :(", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
