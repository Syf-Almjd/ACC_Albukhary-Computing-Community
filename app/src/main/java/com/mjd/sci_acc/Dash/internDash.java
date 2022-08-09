package com.mjd.sci_acc.Dash;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mjd.sci_acc.R;

public class internDash extends AppCompatActivity {
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
        txt.setText("No Albukhary Internships or Work Opportunities Open yet!\nPlease wait for the Schools & PPK announcements");
        btn = findViewById(R.id.moretextDash);
        btn.setText("Show me Other Work & Internships Opportunities");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_webview_page);
                webView = findViewById(R.id.confirmpage_webpage);
                backbtn = findViewById(R.id.backbtn2);
                backbtn.setVisibility(View.VISIBLE);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://www.internsheeps.com/?q=&loc=Penang");
                Toast.makeText(internDash.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
                backbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        backbtn.setVisibility(View.GONE);
                        finish();
                    }
                });
            }
        });
    }
}