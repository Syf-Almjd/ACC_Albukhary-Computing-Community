package com.mjd.sci_acc.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;
import com.mjd.sci_acc.R;
import com.mjd.sci_acc.activity.mainPage;


public class AccountFragment extends Fragment {
    private static final int GALLERY_INTENT_CODE = 1023 ;
    private static FirebaseAuth fAuth;
    Button logout;
    TextView fullName,email,phone,verifyMsg;
    FirebaseFirestore fStore;
    String userId;
    Button resendCode, resetPassLocal;
    CardView changeProfileImage;
    FirebaseUser user;
    ImageView profileImage;
    StorageReference storageReference;
    LinearLayout personalinfo, experience, review;
    TextView personalinfobtn, experiencebtn, reviewbtn;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account1, container, false);

        experiencebtn = v.findViewById(R.id.experiencebtn);


//        phone = v.findViewById(R.id.ACCphone);
//        fullName = v.findViewById(R.id.ACCname);
//        email    = v.findViewById(R.id.ACCemail);
////        resetPassLocal = v.findViewById(R.id.resetPasswordLocal);
//
//        profileImage = v.findViewById(R.id.ACCimage);
//        changeProfileImage = v.findViewById(R.id.ACCimgFrame);
//
//        fAuth = FirebaseAuth.getInstance();
//        fStore = FirebaseFirestore.getInstance();
//        storageReference = FirebaseStorage.getInstance().getReference();
//
//        StorageReference profileRef = storageReference.child("users/"+fAuth.getCurrentUser().getUid()+"/profile.jpg");
//        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                Picasso.get().load("https://cdn0.iconfinder.com/data/icons/user-interface-user-experience-4-3/24/165-512.png").into(profileImage);
//
//            }
//        });

//        resendCode = v.findViewById(R.id.resendCode);
//        verifyMsg = v.findViewById(R.id.verifyMsg);
        personalinfo = v.findViewById(R.id.personalinfo);
        experience = v.findViewById(R.id.experience);
//        review = v.findViewById(R.id.review);
        personalinfobtn = v.findViewById(R.id.personalinfobtn);
        experiencebtn = v.findViewById(R.id.experiencebtn);
//        reviewbtn = v.findViewById(R.id.reviewbtn);
        /*making personal info visible*/
        personalinfo.setVisibility(View.VISIBLE);
        experience.setVisibility(View.GONE);
//        review.setVisibility(View.GONE);
        experiencebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                personalinfo.setVisibility(View.GONE);
                experience.setVisibility(View.VISIBLE);
//                review.setVisibility(View.GONE);
                personalinfobtn.setTextColor(getResources().getColor(R.color.grey));
                experiencebtn.setTextColor(getResources().getColor(R.color.black));
//                reviewbtn.setTextColor(getResources().getColor(R.color.grey));

            }
        });
//
//        userId = fAuth.getCurrentUser().getUid();
//        user = fAuth.getCurrentUser();

//        if(!user.isEmailVerified()){
////            verifyMsg.setVisibility(View.VISIBLE);
////            resendCode.setVisibility(View.VISIBLE);
//
//            resendCode.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(final View v) {
//
//                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void aVoid) {
//                            Toast.makeText(v.getContext(), "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Log.d("tag", "onFailure: Email not sent " + e.getMessage());
//                        }
//                    });
//                }
//            });
//        }
//        logoutFun(v);
        return v;
}

public void logoutFun(View v){

    logout = v.findViewById(R.id.logout);
    logout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getActivity(), mainPage.class));
            getActivity().finish();
        }
    });
}
}
