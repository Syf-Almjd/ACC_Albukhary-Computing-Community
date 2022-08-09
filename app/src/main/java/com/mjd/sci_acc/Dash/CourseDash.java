package com.mjd.sci_acc.Dash;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mjd.sci_acc.R;

public class CourseDash extends AppCompatActivity {
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
        txt.setText("No Albukhary Courses Open yet!\nPlease wait for the Schools announcements");
        btn = findViewById(R.id.moretextDash);
        btn.setText("Show me Other Skill Courses");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_webview_page);
                webView = findViewById(R.id.confirmpage_webpage);
                backbtn = findViewById(R.id.backbtn2);
                backbtn.setVisibility(View.VISIBLE);
                WebSettings webSettings = webView.getSettings();
                webSettings.setSupportMultipleWindows(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setDatabaseEnabled(true);
                webSettings.setAllowFileAccess(true);
                webSettings.setAllowContentAccess(true);
                webSettings.setAllowFileAccess(true);
                webSettings.setUseWideViewPort(true);
                webSettings.setSupportZoom(true);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setJavaScriptCanOpenWindowsAutomatically(false);
                webSettings.setUseWideViewPort(true);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://skillsforall.com/catalog");
                Toast.makeText(CourseDash.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
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