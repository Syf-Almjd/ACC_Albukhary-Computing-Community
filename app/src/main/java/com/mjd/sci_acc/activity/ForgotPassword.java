package com.mjd.sci_acc.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.mjd.sci_acc.R;

public class ForgotPassword extends AppCompatActivity {
    private static final String TAG = fragmentStart.class.getSimpleName();
    private static FirebaseAuth mAuth;
    ImageView btnBack;
    EditText email;
    ProgressBar progressBar;
    Button ChangePass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        progressBar = findViewById(R.id.progressBarFOR);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.FORemail);
        ChangePass = findViewById(R.id.MainBtnFOR);
        ChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        String mail = email.getText().toString();
                        if (TextUtils.isEmpty(mail)) {
                            email.setError("Email is Required.");
                            return;
                        }
                progressBar.setVisibility(View.VISIBLE);
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(ForgotPassword.this, "Reset Link Sent To Your Email.\nCheck your Spam Emails as well", Toast.LENGTH_SHORT).show();
                                finish();
                             }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ForgotPassword.this, "Wrong Email! " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);

                            }
                        });

                    }
                });
        btnBack = findViewById(R.id.backbtn);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}