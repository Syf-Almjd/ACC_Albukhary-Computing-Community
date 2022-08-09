package com.mjd.sci_acc.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mjd.sci_acc.R;


public class add_item_page extends AppCompatActivity {
    ImageButton backbtn;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_page);
        webView = findViewById(R.id.confirmpage_webpage);
        backbtn = findViewById(R.id.backbtn2);
        backbtn.setVisibility(View.VISIBLE);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://docs.google.com/forms/u/7/d/e/1FAIpQLSfRAiRKVdgDsZ1xoe62kSDm7uCm6w8bKgFvhUXWRcsW0-adVA/viewform?usp=send_form");
        Toast.makeText(add_item_page.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backbtn.setVisibility(View.GONE);
                finish();
            }
        });
    }
}