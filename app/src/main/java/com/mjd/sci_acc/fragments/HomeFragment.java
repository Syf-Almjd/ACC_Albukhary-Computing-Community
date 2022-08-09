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

import androidx.fragment.app.Fragment;

import com.mjd.sci_acc.R;


public class HomeFragment extends Fragment {
    public WebView mWebview;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_webview_page, container, false);

        mWebview = view.findViewById(R.id.confirmpage_webpage);
        WebSettings setting = mWebview.getSettings();
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.setWebViewClient(new WebViewClient());
        mWebview.loadUrl("https://thenextweb.com/");
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


