package com.mjd.sci_acc.activity;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mjd.sci_acc.R;

import java.util.HashMap;
import java.util.Map;

public class edit_activity extends AppCompatActivity {
    private static FirebaseAuth mAuth;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    TextView wlcUser, wlcUserID, wlcUserEmail, wlcUserphone;
    Button update;
    String value;
    EditText User_Desc, User_phone, Student_ID, User_name;
    String name, descr, phone, StudentID;
    FirebaseFirestore fStore;
    String userID, Description;
    ImageView btnBackEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        mAuth = FirebaseAuth.getInstance();
        update = findViewById(R.id.btnsend);
        User_name = findViewById(R.id.Name);
        User_Desc = findViewById(R.id.box);
        Student_ID = findViewById(R.id.StudentIDedit);
        User_phone = findViewById(R.id.no);
        fStore = FirebaseFirestore.getInstance();
        btnBackEdit = findViewById(R.id.btnBackEdit);
        btnBackEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = User_name.getText().toString().trim();
                phone = User_phone.getText().toString().trim();
                StudentID = Student_ID.getText().toString().trim();
                Description = User_Desc.getText().toString().trim();

                if (TextUtils.isEmpty(Description)) {
                    User_Desc.setError("Description is Required.");
                    return;
                }
                if (TextUtils.isEmpty(StudentID)) {
                    Student_ID.setError("Student ID is Required.");
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    User_name.setError("Name is Required.");
                    return;
                }
                if (TextUtils.isEmpty(phone)) {
                    User_phone.setError("Phone number is Required.");
                    return;
                }
                if (name.length() < 10) {
                    Toast.makeText(edit_activity.this, "Name Not Found!", Toast.LENGTH_SHORT).show();
                    User_name.setError("Please Type Full Name");
                    return;
                }
                if (phone.length() < 9) {
                    User_phone.setError("Phone Must be >= 9 Numbers");
                    return;
                }
                if (StudentID.length() < 8) {
                    Student_ID.setError("Student ID Must be = 8 Numbers");
                    return;
                }
                userID = mAuth.getCurrentUser().getUid();
                boolean isVerified = mAuth.getCurrentUser().isEmailVerified();
                DocumentReference documentReference = fStore.collection("users").document(userID);
                Map<String, Object> user = new HashMap<>();
                user.put("fName", name);
                user.put("StudentID", StudentID);
                user.put("Phone", phone);
                user.put("isVerified", isVerified);
                user.put("userID", userID);
                user.put("description", Description);

                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(edit_activity.this, "Updated Successfully \n Re-login to See the updates", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onSuccess: user Profile is created for " + userID);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "onFailure: " + e);
                    }
                });
            }
        });

        String userID = mAuth.getUid();
        DocumentReference docRef = db.collection("users").document(userID);

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        value = document.getString("fName");
                        wlcUser = findViewById(R.id.Name);
                        wlcUser.setText(value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        value = document.getString("StudentID");
                        wlcUserID = findViewById(R.id.StudentIDedit);
                        wlcUserID.setText(value.substring(0, 3).toUpperCase() + value.substring(3).toLowerCase());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        value = document.getString("Phone");
                        wlcUserphone = findViewById(R.id.no);
                        wlcUserphone.setText("+6" + value);
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        value = document.getString("description");
                        wlcUserEmail = findViewById(R.id.box);
                        wlcUserEmail.setText(value);
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }
}