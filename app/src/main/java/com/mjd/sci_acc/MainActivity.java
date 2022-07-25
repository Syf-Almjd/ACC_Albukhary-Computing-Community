package com.mjd.sci_acc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mjd.sci_acc.activity.fragmentStart;
import com.mjd.sci_acc.activity.mainPage;

public class MainActivity extends AppCompatActivity {
    private static FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onBackPressed() {
            super.onBackPressed();
        }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Toast.makeText(this, "The Server says: Welcome back! :)", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, fragmentStart.class));
        }
        else {
            startActivity(new Intent(this, mainPage.class));
        }
    }
}
