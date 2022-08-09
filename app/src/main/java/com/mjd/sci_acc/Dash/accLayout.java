package com.mjd.sci_acc.Dash;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mjd.sci_acc.R;
import com.mjd.sci_acc.activity.ContactACC;

public class accLayout extends AppCompatActivity {
    CardView founder, ContactACCbtn, AIcard;
    ImageButton backbtn;
    private Button contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc_layout);
        AIcard = findViewById(R.id.AIcard);
        AIcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(accLayout.this, "Public AI Coming Soon.", Toast.LENGTH_SHORT).show();
            }
        });
        backbtn = findViewById(R.id.backbtnACCPage);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        founder = findViewById(R.id.founderCardview);
        founder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(accLayout.this, com.mjd.sci_acc.activity.founder.class));
            }
        });
        contact = findViewById(R.id.Connectbutton);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/ACCaiuMalaysia"));
                    PackageManager pm = getPackageManager();
                    if (intent.resolveActivity(pm) != null) {
                        startActivity(intent);
                    } else {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/ACCaiuMalaysia")));
                    }
                } catch (Exception ignored) {
                }
            }
        });
        ContactACCbtn = findViewById(R.id.ContactACCbtn);
        ContactACCbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(accLayout.this, ContactACC.class));
            }
        });
    }
}