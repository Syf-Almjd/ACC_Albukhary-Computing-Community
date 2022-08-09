package com.mjd.sci_acc.fragments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.mjd.sci_acc.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {
    public WebView mWebview;
    RelativeLayout whiteLine;

    public ChatFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_webview_page, container, false);

        mWebview = view.findViewById(R.id.confirmpage_webpage);
        whiteLine = view.findViewById(R.id.WhiteLine);
        whiteLine.setVisibility(View.VISIBLE);
        WebSettings setting = mWebview.getSettings();
        mWebview.getSettings().setJavaScriptEnabled(true);
        WebSettings webSettings = mWebview.getSettings();
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
        mWebview.setWebViewClient(new WebViewClient());
        mWebview.loadUrl("https://deadsimplechat.com/UH56z7Lga");
        mWebview.setFocusableInTouchMode(true);
        mWebview.requestFocus();
        mWebview.canGoBack();
        mWebview.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && mWebview.canGoBack()) {
                    mWebview.goBack();
                    return true;
                }
                return false;
            }
        });
        return view;
    }

}


