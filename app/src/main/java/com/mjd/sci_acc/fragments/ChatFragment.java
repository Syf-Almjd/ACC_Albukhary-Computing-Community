package com.mjd.sci_acc.fragments;

import android.content.Context;
import android.content.SharedPreferences;
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

import java.net.HttpURLConnection;


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

        mWebview = (WebView) view.findViewById(R.id.confirmpage_webpage);
        whiteLine = view.findViewById(R.id.WhiteLine);
        whiteLine.setVisibility(View.VISIBLE);
        WebSettings setting = mWebview.getSettings();
        mWebview.getSettings().setJavaScriptEnabled(true);

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
    public void get_cookie(HttpURLConnection conn) {
        SharedPreferences sh_pref_cookie = requireContext().getSharedPreferences("cookies", Context.MODE_PRIVATE);
        String cook_new;
        String COOKIES_HEADER;
        if (conn.getHeaderField("Set-Cookie") != null) {
            COOKIES_HEADER = "Set-Cookie";
        }
        else {
            COOKIES_HEADER = "Cookie";
        }
        cook_new = conn.getHeaderField(COOKIES_HEADER);
        if (cook_new.indexOf("sid", 0) >= 0) {
            SharedPreferences.Editor editor = sh_pref_cookie.edit();
            editor.putString("Cookie", cook_new);
            editor.commit();
        }
    }
    public void set_cookie(HttpURLConnection conn) {
        SharedPreferences sh_pref_cookie = getActivity().getSharedPreferences("cookies", Context.MODE_PRIVATE);
        String COOKIES_HEADER = "Cookie";
        String cook = sh_pref_cookie.getString(COOKIES_HEADER, "no_cookie");
        if (!cook.equals("no_cookie")) {
            conn.setRequestProperty(COOKIES_HEADER, cook);
        }
    }
}


