package com.lizifan.animationdemo1;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_alpha;
    private Button btn_scale;
    private Button btn_tran;
    private Button btn_rotate;
    private Button btn_set;
    private ImageView show;
    private Animation animation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_test);
        init();
    }
    private void init(){
        btn_alpha = findViewById(R.id.btn_alpha);
        btn_scale = findViewById(R.id.btn_scale);
        btn_tran = findViewById(R.id.btn_tran);
        btn_rotate = findViewById(R.id.btn_rotate);
        btn_set = findViewById(R.id.set);
        show = findViewById(R.id.show);
        btn_alpha.setOnClickListener(this);
        btn_scale.setOnClickListener(this);
        btn_tran.setOnClickListener(this);
        btn_rotate.setOnClickListener(this);
        btn_set.setOnClickListener(this);
}
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_alpha:
                AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
                show.startAnimation(animation);
                break;
            case R.id.btn_scale:
                animation = AnimationUtils.loadAnimation(this,
                        R.anim.anim_scale);
                show.startAnimation(animation);
                break;
            case R.id.btn_tran:
                animation = AnimationUtils.loadAnimation(this,
                        R.anim.anim_tran);
                show.startAnimation(animation);
                break;
            case R.id.btn_rotate:
                animation = AnimationUtils.loadAnimation(this,
                        R.anim.anim_rotate);
                show.startAnimation(animation);
                break;
            case R.id.set:
                animation = AnimationUtils.loadAnimation(this,
                        R.anim.anim_set);
                show.startAnimation(animation);
                break;
        }

    }
}
