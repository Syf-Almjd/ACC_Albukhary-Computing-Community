package com.mjd.sci_acc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mjd.sci_acc.R;

public class login extends AppCompatActivity {
    private static final String TAG = fragmentStart.class.getSimpleName();
    private static FirebaseAuth mAuth;
    Button reg, mainLog;
    EditText User_email, User_password;
    String email, password;
    ProgressBar progressBar;
    TextView forgot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progressBarlog);
        User_email = findViewById(R.id.email);
        User_password = findViewById(R.id.txtPassword);
        mAuth = FirebaseAuth.getInstance();
        forgot = findViewById(R.id.BtnFor);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(login.this, ForgotPassword.class));
            }
        });


        reg = findViewById(R.id.ButtonReg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, registration.class));
                finish();
            }
        });
        mainLog = findViewById(R.id.MainBtnLog);
        mainLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = User_email.getText().toString().trim();
                password = User_password.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    User_email.setError("Email is Required.");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    User_password.setError("Email is Required.");
                    return;
                }
                if (password.length() < 6) {
                    User_password.setError("Password Must be >= 6 Characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(login.this, "Authentication Success.",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(login.this, fragmentStart.class));
                                    finish();
                                } else {
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(login.this, "Authentication failed. Please try again :(",
                                            Toast.LENGTH_SHORT).show();
                                }
                                progressBar.setVisibility(View.GONE);

                            }
                        });
            }
        });
    }
}