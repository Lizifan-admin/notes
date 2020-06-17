package com.lizifan.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private FrameView fView;
    private AnimationDrawable anin = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fly = new FrameLayout(this);
        setContentView(fly);
        fView = new FrameView(this);
        fView.setBackgroundResource(R.drawable.anim_zhuan);
        fView.setVisibility(View.INVISIBLE);
        anin = (AnimationDrawable)fView.getBackground();
        fView.setAnim(anin);
        fly.addView(fView);
        fly.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    anin.stop();
                    float x = event.getX();
                    float y = event.getY();
                    fView.setLocation((int)y-40,(int) x-20);
                    fView.setVisibility(View.VISIBLE);
                    anin.start();
                }
                return false;
            }
        });

    }
}
