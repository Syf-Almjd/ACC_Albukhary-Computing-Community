package com.mjd.sci_acc.Dash;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mjd.sci_acc.Events.AnntemsList;
import com.mjd.sci_acc.Events.OrgItemsList;
import com.mjd.sci_acc.R;
import com.mjd.sci_acc.adopters.AnnAdapter;
import com.mjd.sci_acc.adopters.OrgAdapter;

import java.util.ArrayList;
import java.util.List;

public class eventLayout extends AppCompatActivity {
    List<OrgItemsList> orgItemsListList;
    RecyclerView categoriesRecyclerView, announcementsRecycler;
    OrgAdapter OrgAdapter;
    AnnAdapter AnnAdapter;
    List<AnntemsList> announcementsList;
    TextView more, more2;
    ImageButton backbtn, backBTN;
    EditText searchBar;
    TextView add1;
    ImageView add2;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_layout);

        add1 = findViewById(R.id.add1);
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(eventLayout.this, Eventadd.class));
            }
        });

        add2 = findViewById(R.id.add2);
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(eventLayout.this, Eventadd.class));
            }
        });

        searchBar = findViewById(R.id.searchBar);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(eventLayout.this, "Not Found!\nPlease Take a look at the Main Page ✨", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        categoriesRecyclerView = findViewById(R.id.orgRecycle);
        more = findViewById(R.id.allAnnImage);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_webview_page);
                webView = findViewById(R.id.confirmpage_webpage);
                backbtn = findViewById(R.id.backbtn2);
                backbtn.setVisibility(View.VISIBLE);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://www.aiu.edu.my/tag/all-news/");
                Toast.makeText(eventLayout.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
                backbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        backbtn.setVisibility(View.GONE);
                        finish();
                    }
                });
            }
        });

        more2 = findViewById(R.id.allAnnImage2);
        more2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_webview_page);
                webView = findViewById(R.id.confirmpage_webpage);
                backbtn = findViewById(R.id.backbtn2);
                backbtn.setVisibility(View.VISIBLE);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://www.aiu.edu.my/tag/event/");
                Toast.makeText(eventLayout.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
                backbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        backbtn.setVisibility(View.GONE);
                        finish();
                    }
                });
            }
        });
        backBTN = findViewById(R.id.backbtnEVENT);
        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        orgItemsListList = new ArrayList<>();
        orgItemsListList.add(new OrgItemsList(1, R.drawable.asu));
        orgItemsListList.add(new OrgItemsList(2, R.drawable.afsa));
        orgItemsListList.add(new OrgItemsList(3, R.drawable.atsa));
        orgItemsListList.add(new OrgItemsList(4, R.drawable.masaa));
        orgItemsListList.add(new OrgItemsList(5, R.drawable.sa));
        orgItemsListList.add(new OrgItemsList(6, R.drawable.ass));

        setOrgRecycler(orgItemsListList);

        announcementsRecycler = findViewById(R.id.announcementsRecycler);
        announcementsList = new ArrayList<>();
        announcementsList.add(new AnntemsList(1, R.drawable.ann1));
        announcementsList.add(new AnntemsList(2, R.drawable.ann2));
        announcementsList.add(new AnntemsList(3, R.drawable.ann3));
        announcementsList.add(new AnntemsList(4, R.drawable.ann4));
        announcementsList.add(new AnntemsList(5, R.drawable.ann5));
        announcementsList.add(new AnntemsList(6, R.drawable.ann6));

        setAnnRecycler(announcementsList);
    }

    private void setOrgRecycler(List<OrgItemsList> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoriesRecyclerView.setLayoutManager(layoutManager);
        OrgAdapter = new OrgAdapter(this, dataList);
        categoriesRecyclerView.setAdapter(OrgAdapter);
    }

    private void setAnnRecycler(List<AnntemsList> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        announcementsRecycler.setLayoutManager(layoutManager);
        AnnAdapter = new AnnAdapter(this, dataList);
        announcementsRecycler.setAdapter(AnnAdapter);
    }
}
