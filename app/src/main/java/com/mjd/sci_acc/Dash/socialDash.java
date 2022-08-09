package com.mjd.sci_acc.Dash;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mjd.sci_acc.R;
import com.mjd.sci_acc.adopters.MainSocialList;

public class socialDash extends AppCompatActivity {
    ImageView ListImage;
    EditText searchBar;
    ImageButton backBTN;
    ListView mainlist;

    String[] name = {
            "Albukhary Computing Community", "Malaysia ICT Volunteer",
            "AIU Cyber Experts", "AIU Valeriy", "Support Local Market",

    };
    String[] corpname = {
            "MJD Development", "MCMC Program",
            "School of Computing and Informatics", "MJD Development", "AIU Students",

    };
    Integer[] imageUrl = {
            R.mipmap.ic_launcher, R.drawable.mcmc_logo,
            R.drawable.aiu_logo, R.drawable.aiu_valeriy, R.drawable.aiu_logo,
    };
    String[] rate = {
            "4.9", "5.0",
            "Coming Soon", "Soon", "Soon",
    };
    String[] type = {
            "Featured", "New",
            "Soon", "Under Development", "Understudy",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_projects);
        searchBar = findViewById(R.id.searchBarSocial);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(socialDash.this, "Couldn't find it:(\nPlease Take a look at the Main Page ✨", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        MainSocialList adapter = new MainSocialList(this, name, corpname, imageUrl, rate, type);
        mainlist = (ListView) findViewById(R.id.mainservices);
        mainlist.setAdapter(adapter);
        mainlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Toast.makeText(socialDash.this, "ACC is one of MJD's latest Social Projects in AIU!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(socialDash.this, accLayout.class));
                } else if (position == 1) {
                    Toast.makeText(getApplicationContext(), "MIIV were organized in cooperation between AIU and MCMC", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(socialDash.this, mcmc.class));
                } else if (position == 2) {
                    Toast.makeText(getApplicationContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
                } else if (position == 3) {
                    Toast.makeText(getApplicationContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
                } else if (position == 4) {
                    Toast.makeText(getApplicationContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
                }

            }
        });

        ListImage = findViewById(R.id.imagelist);
        ListImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(socialDash.this, "Listed Latest to Oldest", Toast.LENGTH_SHORT).show();
            }
        });
        backBTN = findViewById(R.id.backbtnSOCIAL);
        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}