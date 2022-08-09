package com.mjd.sci_acc.activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mjd.sci_acc.R;

public class ContactACC extends AppCompatActivity {
    public TextView text;
    ImageButton btnback;
    Button send, btnmore;
    EditText name, no, subject, boxtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        text = findViewById(R.id.txtContact);
        text.setText("ACC is excited for you coming\nMessage!");
        name = findViewById(R.id.Name);
        no = findViewById(R.id.no);
        subject = findViewById(R.id.subject);
        boxtxt = findViewById(R.id.box);
        send = findViewById(R.id.btnsend);
        btnback = findViewById(R.id.backbtn);

        btnmore = findViewById(R.id.moretext);
        btnmore.setVisibility(View.GONE);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sent();
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }

    public void sent() {
        String noinput = no.getText().toString();
        String nameinput = name.getText().toString();
        String subjectinput = subject.getText().toString();
        String boxinput = boxtxt.getText().toString();

        String uriText =
                "mailto:acc.aiu.my@gmail.com" +
                        "?subject=" + Uri.encode(subjectinput) +
                        "&body=" + Uri.encode("Hi ACC\nI am " + nameinput + " with phone number " + noinput + " would like to say { " + boxinput + " }\nThank you");
        Uri uri = Uri.parse(uriText);
        Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
        sendIntent.setData(uri);
        startActivity(Intent.createChooser(sendIntent, "Send email"));
        Toast.makeText(ContactACC.this, "Thank you ✨, It's Ready!", Toast.LENGTH_SHORT).show();
    }
}