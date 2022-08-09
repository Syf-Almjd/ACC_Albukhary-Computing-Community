package com.mjd.sci_acc.Dash;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mjd.sci_acc.R;

public class mcmc extends AppCompatActivity {
    ImageButton btnback;
    Button option1, option2, option3, moretext;
    ImageButton backbtn;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcmc_layout);

        btnback = findViewById(R.id.backbtn);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);


        moretext = findViewById(R.id.moretext);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_webview_page);
                webView = findViewById(R.id.confirmpage_webpage);
                backbtn = findViewById(R.id.backbtn2);
                backbtn.setVisibility(View.VISIBLE);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://www.canva.com/design/DAFHOmZGl_k/P-bxUlft6obhixrkHoSl1A/view?utm_content=DAFHOmZGl_k&utm_campaign=designshare&utm_medium=link&utm_source=publishpresent");
                Toast.makeText(mcmc.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
                backbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        backbtn.setVisibility(View.GONE);
                        finish();
                    }
                });
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_webview_page);
                webView = findViewById(R.id.confirmpage_webpage);
                backbtn = findViewById(R.id.backbtn2);
                backbtn.setVisibility(View.VISIBLE);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://www.canva.com/design/DAFHO38v8t4/YNSWVa8c2vNEkXStJ85wpw/view?utm_content=DAFHO38v8t4&utm_campaign=designshare&utm_medium=link&utm_source=publishpresent");
                Toast.makeText(mcmc.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
                backbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        backbtn.setVisibility(View.GONE);
                        finish();
                    }
                });
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_webview_page);
                webView = findViewById(R.id.confirmpage_webpage);
                backbtn = findViewById(R.id.backbtn2);
                backbtn.setVisibility(View.VISIBLE);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://www.canva.com/design/DAFHO_3FEx8/mqHfUeb-ZfGXQPsiKnU7iA/view?utm_content=DAFHO_3FEx8&utm_campaign=designshare&utm_medium=link&utm_source=publishpresent");
                Toast.makeText(mcmc.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
                backbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        backbtn.setVisibility(View.GONE);
                        finish();
                    }
                });
            }
        });
        moretext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_webview_page);
                webView = findViewById(R.id.confirmpage_webpage);
                backbtn = findViewById(R.id.backbtn2);
                backbtn.setVisibility(View.VISIBLE);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://www.itu.int/net4/wsis/archive/stocktaking/Project/Details?projectId=1514527651");
                Toast.makeText(mcmc.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
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