package com.mjd.sci_acc.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.mjd.sci_acc.R;
import com.mjd.sci_acc.activity.add_item_page;
import com.mjd.sci_acc.activity.heart_items_Store;


public class StoreFragment extends Fragment {
    public WebView mWebview;
    ImageButton backbtn;
    ImageView heart, add, ListImage;

    public StoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_store, container, false);

        mWebview = view.findViewById(R.id.confirmpage_webpage_Store);
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
        mWebview.loadUrl("https://accaiu.wordpress.com/");
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
        ListImage = view.findViewById(R.id.imageView3);
        ListImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Listed Latest to Oldest", Toast.LENGTH_SHORT).show();
            }
        });
        heart = view.findViewById(R.id.heartStore);
        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), heart_items_Store.class));
            }
        });
        add = view.findViewById(R.id.AddStore);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), add_item_page.class));
            }
        });
        return view;
    }
}