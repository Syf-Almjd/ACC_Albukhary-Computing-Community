package com.mjd.sci_acc.activity;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.auth.FirebaseUser;
import com.mjd.sci_acc.R;
import com.mjd.sci_acc.activity.StartAnimation.MainScreen;

public class ForgotPassword extends AppCompatActivity {
    private static FirebaseAuth mAuth;
    ImageView btnBackFOR;
    EditText email;
    ProgressBar progressBar;
    Button ChangePass, VerAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        progressBar = findViewById(R.id.progressBarFOR);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.FORemail);
        VerAcc = findViewById(R.id.VerAcc);
        VerAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser fuser = mAuth.getCurrentUser();

                fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ForgotPassword.this, "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "onFailure: Email not sent " + e.getMessage());
                    }
                });
                mAuth.signOut();
                Toast.makeText(ForgotPassword.this, "Please check you spam folder and Login in again", Toast.LENGTH_SHORT).show();
                startActivity(MainScreen.newIntent(ForgotPassword.this, true, true));
                finish();
            }
        });
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
        btnBackFOR = findViewById(R.id.backbtnFOR);
        btnBackFOR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}