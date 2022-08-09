package com.mjd.sci_acc.activity.StartAnimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.mjd.sci_acc.R;
import com.mjd.sci_acc.activity.login;
import com.mjd.sci_acc.activity.registration;

import java.util.concurrent.TimeUnit;

public class MainScreen extends FragmentActivity {

    public static final String EXTRA_MAGIKARP = "magikarp";
    public static final String EXTRA_ANIMATED = "animated";

    private static final long CONTENT_LOAD_TIME = TimeUnit.MILLISECONDS.toMillis(500);
    Button reg, log;

    public static Intent newIntent(Context context, boolean magikarp, boolean animated) {
        return new Intent(context, MainScreen.class)
                .putExtra(EXTRA_MAGIKARP, magikarp)
                .putExtra(EXTRA_ANIMATED, animated);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        // initialize demo stuff
        final boolean magikarp = getIntent().getBooleanExtra(EXTRA_MAGIKARP, false);
        final Runnable splash = loadSplashScreen(magikarp);

        // simulate content loading
        new Handler().postDelayed(() -> showContent(splash), CONTENT_LOAD_TIME);
        reg = findViewById(R.id.BtnReg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, registration.class));

            }
        });

        log = findViewById(R.id.Btnlog);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, login.class));
            }
        });
    }


    private Runnable loadSplashScreen(boolean magikarp) {
        if (magikarp) {
            boolean animated = getIntent().getBooleanExtra(EXTRA_ANIMATED, false);

            final RevealCallback callback = Magikarp.splash(this, R.drawable.splash_screen);

            if (animated) {
                return () -> callback.reveal(createSplashAnimation(callback));
            } else {
                return callback::reveal;
            }
        } else {
            return () -> {
            };
        }
    }

    private Animator createSplashAnimation(RevealCallback callback) {
        final Drawable drawable =
                ((LayerDrawable) callback.getDrawable()).findDrawableByLayerId(R.id.icon);
        final float dp100 =
                TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());

        final ValueAnimator splashAnimator = ValueAnimator.ofInt(0, (int) dp100, 0);
        splashAnimator.setDuration(1500);
        splashAnimator.setInterpolator(new AnticipateOvershootInterpolator());
        splashAnimator.setRepeatMode(ValueAnimator.RESTART);
        splashAnimator.setStartDelay(150);
        splashAnimator.setRepeatCount(3);

        final Rect drawableBounds = drawable.copyBounds();
        final int top = drawableBounds.top;
        final int left = drawableBounds.left;
        splashAnimator.addUpdateListener(
                animation -> {
                    drawable.copyBounds(drawableBounds);
                    int value = (int) animation.getAnimatedValue();
                    drawableBounds.offsetTo(left, top - value);
                    drawable.setBounds(drawableBounds);
                });

        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(splashAnimator, callback.createRevealAnimator());
        return animatorSet;
    }

    private void showContent(@NonNull Runnable splash) {
        splash.run();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME));
        finish();
    }
}