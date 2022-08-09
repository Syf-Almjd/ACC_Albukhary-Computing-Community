package com.mjd.sci_acc.fragments;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mjd.sci_acc.Dash.eventLayout;
import com.mjd.sci_acc.Dash.internDash;
import com.mjd.sci_acc.R;


public class dashboardFragment extends Fragment {
    public WebView mWebview;
    TextView wlcUser;
    String value;
    CardView aiuLayout, eventDash, socialDash, CourseDash, InternDash;
    ImageButton backbtn;
    FirebaseAuth mAuth;
    String userID;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public dashboardFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mAuth = FirebaseAuth.getInstance();

        userID = mAuth.getUid();

        DocumentReference docRef = db.collection("users").document(userID);

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        value = document.getString("fName");
                        wlcUser = view.findViewById(R.id.txtHello);
                        wlcUser.setText("Welcome to your Dashboard, " + value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase() + "!");
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });


        aiuLayout = view.findViewById(R.id.homeDash);
        aiuLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Let's Discover AIU ✨", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), com.mjd.sci_acc.Dash.aiuLayout.class));
            }
        });


        socialDash = view.findViewById(R.id.socialDash);
        socialDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Making a Global Social Impact \uD83D\uDCE3✨", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), com.mjd.sci_acc.Dash.socialDash.class));
            }

        });
        eventDash = view.findViewById(R.id.eventDash);
        eventDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Schools Events and Announcements! ⭐", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), eventLayout.class));
            }
        });
        InternDash = view.findViewById(R.id.InternDash);
        InternDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), internDash.class));
            }
        });
        CourseDash = view.findViewById(R.id.CourseDash);
        CourseDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), com.mjd.sci_acc.Dash.CourseDash.class));
            }
        });
        return view;
    }
}