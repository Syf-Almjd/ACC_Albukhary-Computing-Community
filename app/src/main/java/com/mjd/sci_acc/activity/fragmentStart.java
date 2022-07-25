package com.mjd.sci_acc.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.mjd.sci_acc.R;
import com.mjd.sci_acc.fragments.AccountFragment;
import com.mjd.sci_acc.fragments.ChatFragment;
import com.mjd.sci_acc.fragments.HomeFragment;
import com.mjd.sci_acc.fragments.StoreFragment;
import com.mjd.sci_acc.fragments.dashboardFragment;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class fragmentStart extends AppCompatActivity {
    private static final String TAG = fragmentStart.class.getSimpleName();
    AnimatedBottomBar animatedBottomBar;
    WebView webView;

    public HomeFragment HomeFragment = new HomeFragment();
    public dashboardFragment dashboardFragment = new dashboardFragment();
    public ChatFragment ChatFragment = new ChatFragment();
    public StoreFragment StoreFragment = new StoreFragment();
    public AccountFragment AccountFragment = new AccountFragment();

    Fragment selected = HomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragement_start);
        animatedBottomBar = findViewById(R.id.animatedBottomBar);
        createFragment(HomeFragment);
        createFragment(ChatFragment);
        createFragment(dashboardFragment);
        createFragment(StoreFragment);
        createFragment(AccountFragment);

            animatedBottomBar.selectTabById(R.id.home, true);
            showFragment(HomeFragment);


        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NotNull AnimatedBottomBar.Tab newTab) {
                Fragment fragment = null;
                switch (newTab.getId()) {
                    case R.id.home:
                        Toast.makeText(fragmentStart.this, "Loading Latest's for you! ✨", Toast.LENGTH_SHORT).show();
                        hideFragment(selected);
                        selected = HomeFragment;
                        showFragment(HomeFragment);
                        break;
                    case R.id.category:
                        hideFragment(selected);
                        selected = dashboardFragment;
                        showFragment(dashboardFragment);
                        break;
                    case R.id.chat:
                        hideFragment(selected);
                        selected = ChatFragment;
                        showFragment(ChatFragment);
                        break;
                    case R.id.store:
                        hideFragment(selected);
                        selected = StoreFragment;
                        showFragment(StoreFragment);
                        break;
                    case R.id.account:
                        hideFragment(selected);
                        selected = AccountFragment;
                        showFragment(AccountFragment);
                        break;
                }
            }
        });
    }

    private void createFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment)
                .hide(fragment)
                .commit();
    }
    private void showFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .show(fragment)
                .commit();
    }

    private void hideFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .hide(fragment)
                .commit();
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME));
    }
}