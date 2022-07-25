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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mjd.sci_acc.R;

import java.util.HashMap;
import java.util.Map;

public class registration extends AppCompatActivity {
    private static final String TAG = fragmentStart.class.getSimpleName();
    private static FirebaseAuth mAuth;
    Button log, mainReg;
    EditText User_email, User_password, User_phone, User_name;
    String name, email, password, phone;
    ProgressBar progressBar;
    TextView forgot;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        User_name = findViewById(R.id.Regname);
        User_email = findViewById(R.id.Regemail);
        User_password = findViewById(R.id.Regpass);
        User_phone = findViewById(R.id.RegPhone);
        progressBar = findViewById(R.id.progressBarReg);

        fStore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        forgot = findViewById(R.id.btnFor);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        startActivity(new Intent(registration.this, ForgotPassword.class));
            }
        });


        log = findViewById(R.id.ButtonLog);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(registration.this, login.class));
                finish();
            }
        });
        mainReg = findViewById(R.id.MainBtnReg);
        mainReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = User_name.getText().toString().trim();
                email = User_email.getText().toString().trim();
                password = User_password.getText().toString().trim();
                phone = User_phone.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    User_email.setError("Email is Required.");
                    return;
                }
                if (TextUtils.isEmpty(phone)) {
                    User_phone.setError("Phone Number is Required.");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    User_password.setError("Password is Required.");
                    return;
                }
                if (password.length() < 6) {
                    User_password.setError("Password Must be >= 6 Characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(registration.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser fuser = mAuth.getCurrentUser();
                                    fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Toast.makeText(registration.this, "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.d(TAG, "onFailure: Email not sent " + e.getMessage());
                                        }
                                    });

                                    Toast.makeText(registration.this, "User Created.", Toast.LENGTH_SHORT).show();
                                    userID = mAuth.getCurrentUser().getUid();
                                    DocumentReference documentReference = fStore.collection("users").document(userID);
                                    Map<String,Object> user = new HashMap<>();
                                    user.put("fName",name);
                                    user.put("email",email);
                                    user.put("phone",phone);

                                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "onSuccess: user Profile is created for "+ userID);
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.d(TAG, "onFailure: " + e.toString());
                                        }
                                    });

                                    Log.d(TAG, "createUserWithEmail:success");
                                    Toast.makeText(registration.this, "Authentication Success.",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(registration.this, fragmentStart.class));
                                    finish();
                                } else {
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(registration.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                                progressBar.setVisibility(View.GONE);
                            }
                        });
            }
        });
    }
}