package com.mjd.sci_acc.Dash;


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

public class Eventadd extends AppCompatActivity {
    public TextView text, subjecttxt, messagetxt;
    ImageButton btnback;
    Button send, btnmore;
    EditText name, no, subject, boxtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        subjecttxt = findViewById(R.id.subject);
        subjecttxt.setHint("Venue (Auditorium, LT2, SH etc..)");
        messagetxt = findViewById(R.id.box);
        messagetxt.setHint("Event Details");

        text = findViewById(R.id.txtContact);
        text.setText("Let's have fun and\nEnjoy!!");
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
                        "&body=" + Uri.encode("Hi ACC\nI am " + nameinput + " with phone number " + noinput + " would like add an event { " + boxinput + " }\nThank you");
        Uri uri = Uri.parse(uriText);
        Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
        sendIntent.setData(uri);
        startActivity(Intent.createChooser(sendIntent, "Send email"));
        Toast.makeText(Eventadd.this, "Thank you for letting us know about the event ✨", Toast.LENGTH_SHORT).show();
    }
}