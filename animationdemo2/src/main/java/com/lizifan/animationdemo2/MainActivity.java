package com.lizifan.animationdemo2;

import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private LinearLayout start_ctrl;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_ctrl = findViewById(R.id.start_ctrl);
        final TranslateAnimation translateAnimation = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_SELF,0,TranslateAnimation.RELATIVE_TO_SELF,0,
                TranslateAnimation.RELATIVE_TO_SELF,1,TranslateAnimation.RELATIVE_TO_SELF,0);
        translateAnimation.setDuration(3000);
        start_ctrl.postDelayed(new Runnable() {
            @Override
            public void run() {
                start_ctrl.setVisibility(View.VISIBLE);
                start_ctrl.setAnimation(translateAnimation);
            }
        },2000);
    }
}
