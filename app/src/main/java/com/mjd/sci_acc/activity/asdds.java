package com.mjd.sci_acc.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.mjd.sci_acc.R;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;


//private static final int GALLERY_INTENT_CODE = 1023 ;
//private static FirebaseAuth fAuth;
//        Button logout;
//        TextView fullName,email,phone,verifyMsg;
//        FirebaseFirestore fStore;
//        String userId;
//        Button resendCode, resetPassLocal;
//        CardView changeProfileImage;
//        FirebaseUser user;
//        ImageView profileImage;
//        StorageReference storageReference;
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
public class asdds extends AppCompatActivity {
    //    AsyncTask<String, Void, String>
    String data = "pass=ahmed&nama=asd&x=37&y=18";
    String loginUrl = "https://studentportal.aiu.edu.my/OSI_AIU/OSI_semaklogin.jsp";
//    String Login = POST_req(loginUrl, data, 10000); /*last parameter is a limit of page content length*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asdds);
        Button asd1 = findViewById(R.id.save);
        asd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                POST_req(loginUrl, data, 10000);
                new MyTask().execute();
            }
        });
    }

    public class MyTask extends AsyncTask<Void, Void, Void> {
        String data = "pass=d&nama=d&x=37&y=18";
        String loginUrl = "https://studentportal.aiu.edu.my/OSI_AIU/OSI_semaklogin.jsp";
//    String Login = POST_req(loginUrl, data, 10000); /*last parameter is a limit of page content length*/

        @Override
        protected Void doInBackground(Void... voids) {
            POST_req(loginUrl, data, 10000);
            return null;
        }

        public String POST_req(String url, String post_data, int len) {
            URL addr = null;
            try {
                addr = new URL(url);
            } catch (MalformedURLException e) {
                return "Incorrect URL";
            }
            StringBuffer data = new StringBuffer();
            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection) addr.openConnection();
            } catch (IOException e) {
                return "Open connection error";
            }

            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Accept-Language", "ru,en-GB;q=0.8,en;q=0.6");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            conn.setRequestProperty("Cookie", "");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //conn.setInstanceFollowRedirects(true);
            set_cookie(conn);

            //POST data:
            String post_str = post_data;
            data.append(post_str);
            try {
                conn.connect();
            } catch (IOException e) {
                return "Connecting error";
            }
            DataOutputStream dataOS = null;
            try {
                dataOS = new DataOutputStream(conn.getOutputStream());
            } catch (IOException e2) {
                return "Out stream error";
            }
            try {
                dataOS.writeBytes(data.toString());
            } catch (IOException e) {
                return "Out stream error 1";
            }

            /*If redirect: */
            int status;
            try {
                status = conn.getResponseCode();
            } catch (IOException e2) {
                return "Response error";
            }
            if (status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM || status == HttpURLConnection.HTTP_SEE_OTHER) {
                String new_url = conn.getHeaderField("Location");
                String cookies = conn.getHeaderField("Set-Cookie");
                URL red_url;
                try {
                    red_url = new URL(new_url);
                } catch (MalformedURLException e) {
                    return "Redirect error";
                }
                try {
                    conn = (HttpURLConnection) red_url.openConnection();
                } catch (IOException e) {
                    return "Redirect connection error";
                }
                //conn.setRequestProperty("Content-type", "text/html");
                conn.setRequestProperty("Connection", "keep-alive");
                conn.setRequestProperty("Accept-Language", "ru,en-GB;q=0.8,en;q=0.6");
                conn.setRequestProperty("Accept-Charset", "utf-8");
                conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                conn.setRequestProperty("Cookie", cookies);
                conn.setDoOutput(true);
                conn.setDoInput(true);
                //conn.setInstanceFollowRedirects(true);
            }

            java.io.InputStream in = null;
            try {
                in = conn.getInputStream();
            } catch (IOException e) {
                return "In stream error";
            }
            InputStreamReader reader = null;
            reader = new InputStreamReader(in, StandardCharsets.UTF_8);
            char[] buf = new char[len];
            try {
                reader.read(buf);
            } catch (IOException e) {
                return "In stream error";
            }
            get_cookie(conn);

            return (new String(buf));
        }

        public void get_cookie(HttpURLConnection conn) {
            SharedPreferences sh_pref_cookie;
            sh_pref_cookie = getSharedPreferences("cookies", Context.MODE_PRIVATE);
            String cook_new;
            String COOKIES_HEADER;
            if (conn.getHeaderField("Set-Cookie") != null) {
                COOKIES_HEADER = "Set-Cookie";
            } else {
                COOKIES_HEADER = "Cookie";
            }
            cook_new = conn.getHeaderField(COOKIES_HEADER);
            if (cook_new.indexOf("sid") >= 0) {
                SharedPreferences.Editor editor = sh_pref_cookie.edit();
                editor.putString("Cookie", cook_new);
                editor.commit();
            }
        }

        public void set_cookie(HttpURLConnection conn) {

            SharedPreferences sh_pref_cookie = getSharedPreferences("cookies", Context.MODE_PRIVATE);
            String COOKIES_HEADER = "Cookie";
            String cook = sh_pref_cookie.getString(COOKIES_HEADER, "no_cookie");
            if (!cook.equals("no_cookie")) {
                conn.setRequestProperty(COOKIES_HEADER, cook);
            }
        }


        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
        }
    }
}