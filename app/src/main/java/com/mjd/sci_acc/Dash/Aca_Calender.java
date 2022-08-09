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

public class Aca_Calender extends AppCompatActivity {
    Button SBSS, SCI, SEHS, foundation, LC;
    ImageButton backbtn;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aiu_schools);

        backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        SBSS = findViewById(R.id.SBSS);
        SEHS = findViewById(R.id.SEHS);
        SCI = findViewById(R.id.SCI);

        foundation = findViewById(R.id.Foundation);
        LC = findViewById(R.id.LC);

        SBSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_webview_page);
                webView = findViewById(R.id.confirmpage_webpage);
                backbtn = findViewById(R.id.backbtn2);
                backbtn.setVisibility(View.VISIBLE);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + "https://accaiu.files.wordpress.com/2022/08/ugp-academic-calendar-2021-2022.pdf");
                Toast.makeText(Aca_Calender.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
                backbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        backbtn.setVisibility(View.GONE);
                        finish();
                    }
                });
            }
        });


        SEHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_webview_page);
                webView = findViewById(R.id.confirmpage_webpage);
                backbtn = findViewById(R.id.backbtn2);
                backbtn.setVisibility(View.VISIBLE);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + "https://accaiu.files.wordpress.com/2022/08/ugp-academic-calendar-2021-2022.pdf");
                Toast.makeText(Aca_Calender.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
                backbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        backbtn.setVisibility(View.GONE);
                        finish();
                    }
                });
            }
        });

        SCI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.activity_webview_page);
                webView = findViewById(R.id.confirmpage_webpage);
                backbtn = findViewById(R.id.backbtn2);
                backbtn.setVisibility(View.VISIBLE);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + "https://accaiu.files.wordpress.com/2022/08/ugp-academic-calendar-2021-2022.pdf");
                Toast.makeText(Aca_Calender.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
                backbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        backbtn.setVisibility(View.GONE);
                        finish();
                    }
                });
            }
        });

//                setContentView(R.layout.activity_webview_page);
//                webView = findViewById(R.id.confirmpage_webpage);
//                backbtn = findViewById(R.id.backbtn2);
//                backbtn.setVisibility(View.VISIBLE);
//                webView.setWebViewClient(new WebViewClient());
//                webView.getSettings().setJavaScriptEnabled(true);
//                Toast.makeText(Aca_Calender.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
//                backbtn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        backbtn.setVisibility(View.GONE);
//                        finish();
//                    }
//                });
//            }
//        });

        foundation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_webview_page);
                webView = findViewById(R.id.confirmpage_webpage);
                backbtn = findViewById(R.id.backbtn2);
                backbtn.setVisibility(View.VISIBLE);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + "https://accaiu.files.wordpress.com/2022/08/fsp-academic-calendar-2021-2022.pdf");
                Toast.makeText(Aca_Calender.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
                backbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        backbtn.setVisibility(View.GONE);
                        finish();
                    }
                });
            }
        });
        LC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Aca_Calender.this, "Language Center Student Don't have a Calender :(!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}