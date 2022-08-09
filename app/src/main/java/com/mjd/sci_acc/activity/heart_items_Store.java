package com.mjd.sci_acc.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mjd.sci_acc.R;

public class heart_items_Store extends AppCompatActivity {
    public WebView webView;
    ImageButton backbtn;
    TextView txt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.na_layout);
        backbtn = findViewById(R.id.backbtnDash);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        txt = findViewById(R.id.txtmainDash);
        txt.setText("No items added yet!");
        btn = findViewById(R.id.moretextDash);
        btn.setVisibility(View.INVISIBLE);
    }
}