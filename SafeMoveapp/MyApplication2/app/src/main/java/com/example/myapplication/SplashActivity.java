package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView icon;
    ImageView icon2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        icon = findViewById(R.id.iconImageView);

        startAnimation();
    }

    private void startAnimation() {
        Animation drop = AnimationUtils.loadAnimation(this, R.anim.drop_animation);
        drop.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                proceedToMain();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        icon.startAnimation(drop);
    }
    private void proceedToMain() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}