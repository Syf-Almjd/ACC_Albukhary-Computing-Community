package com.mjd.sci_acc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mjd.sci_acc.Dash.aiuLayout;
import com.mjd.sci_acc.R;

public class founder extends AppCompatActivity {
    LinearLayout course, contactEmail, aiu;
    ImageButton backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_founder);
        course = findViewById(R.id.course);
        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(founder.this, "Bachelor of Computer Science (Honours)", Toast.LENGTH_SHORT).show();
            }
        });
        aiu = findViewById(R.id.aiu);
        aiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(founder.this, aiuLayout.class));
            }
        });
        backbtn = findViewById(R.id.backbtnFounder);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        contactEmail = findViewById(R.id.contactEmail);
        contactEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(founder.this, ContactACC.class));
            }
        });
    }
}