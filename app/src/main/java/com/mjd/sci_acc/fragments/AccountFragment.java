package com.mjd.sci_acc.fragments;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mjd.sci_acc.R;
import com.mjd.sci_acc.activity.ForgotPassword;
import com.mjd.sci_acc.activity.StartAnimation.MainScreen;
import com.mjd.sci_acc.activity.edit_activity;


public class AccountFragment extends Fragment {
    FirebaseAuth mAuth;

    LinearLayout personalinfo, experience, review;
    TextView personalinfobtn, experiencebtn, reviewbtn;
    ImageButton acclogout;
    ImageView FORaccount;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    TextView wlcUser, wlcUserID, wlcUserEmail, wlcUserphone;
    String value;
    TextView edit1, edit2, edit3;
    String userID;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account, container, false);
        mAuth = FirebaseAuth.getInstance();
        userID = mAuth.getUid();

        DocumentReference docRef = db.collection("users").document(userID);
        boolean isVerified = mAuth.getCurrentUser().isEmailVerified();

        edit1 = v.findViewById(R.id.edit1);
        edit2 = v.findViewById(R.id.edit2);
        edit3 = v.findViewById(R.id.edit3);
        edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isVerified == true) {
                    startActivity(new Intent(getActivity(), edit_activity.class));
                } else {
                    Toast.makeText(getActivity(), "Please Verify you Email!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        edit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isVerified == true) {
                    startActivity(new Intent(getActivity(), edit_activity.class));
                } else {
                    Toast.makeText(getActivity(), "Please Verify you Email!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        edit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isVerified == true) {
                    startActivity(new Intent(getActivity(), edit_activity.class));
                } else {
                    Toast.makeText(getActivity(), "Please Verify you Email!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        personalinfo = v.findViewById(R.id.personalinfo);
        experience = v.findViewById(R.id.experience);
        review = v.findViewById(R.id.review);

        personalinfobtn = v.findViewById(R.id.personalinfobtn);
        experiencebtn = v.findViewById(R.id.experiencebtn);
        reviewbtn = v.findViewById(R.id.reviewbtn);
        /*making personal info visible*/
        personalinfo.setVisibility(View.VISIBLE);
        experience.setVisibility(View.GONE);
        review.setVisibility(View.GONE);

        personalinfobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                personalinfo.setVisibility(View.VISIBLE);
                experience.setVisibility(View.GONE);
                review.setVisibility(View.GONE);
                personalinfobtn.setTextColor(getResources().getColor(R.color.colorP2));
                experiencebtn.setTextColor(getResources().getColor(R.color.grey));
                reviewbtn.setTextColor(getResources().getColor(R.color.grey));

            }
        });

        experiencebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                personalinfo.setVisibility(View.GONE);
                experience.setVisibility(View.VISIBLE);
                review.setVisibility(View.GONE);
                personalinfobtn.setTextColor(getResources().getColor(R.color.grey));
                experiencebtn.setTextColor(getResources().getColor(R.color.colorP2));
                reviewbtn.setTextColor(getResources().getColor(R.color.grey));

            }
        });

        reviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                personalinfo.setVisibility(View.GONE);
                experience.setVisibility(View.GONE);
                review.setVisibility(View.VISIBLE);
                personalinfobtn.setTextColor(getResources().getColor(R.color.grey));
                experiencebtn.setTextColor(getResources().getColor(R.color.grey));
                reviewbtn.setTextColor(getResources().getColor(R.color.colorP2));

            }
        });
        FORaccount = v.findViewById(R.id.FORaccount);
        FORaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ForgotPassword.class));
            }
        });

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        value = document.getString("fName");
                        wlcUser = v.findViewById(R.id.ACCname);
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
                        wlcUserID = v.findViewById(R.id.StudentIDAcc);
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
                        wlcUserphone = v.findViewById(R.id.ACCphone);
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
                        value = document.getString("email");
                        wlcUserEmail = v.findViewById(R.id.ACCemail);
                        wlcUserEmail.setText(value);
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
                        wlcUserEmail = v.findViewById(R.id.DescriptionACC);
                        wlcUserEmail.setText(value);
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

        acclogout = v.findViewById(R.id.ACClogout);
        acclogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                FirebaseAuth.getInstance().signOut();
                                startActivity(MainScreen.newIntent(getActivity(), true, true));
                                getActivity().finish();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Are you sure you want to logout?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();

            }
        });


        return v;
    }

}
