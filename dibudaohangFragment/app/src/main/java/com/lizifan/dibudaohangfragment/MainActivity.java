package com.lizifan.dibudaohangfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txt_topbar;
    private RelativeLayout rl_channel;
    private TextView txt_channel;
    private TextView channel_num;
    private RelativeLayout rl_message;
    private TextView txt_message;
    private TextView message_num;
    private RelativeLayout rl_better;
    private TextView txt_better;
    private TextView better_num;
    private RelativeLayout rl_my;
    private TextView txt_setting;
    private ImageView my_red;
    private FrameLayout ly_content;

    private MyFragment f1;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        f1 = new MyFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_content,f1).commit();
        initData();
        rl_channel.performClick();
    }
    private void initData(){
        txt_topbar = findViewById(R.id.top);
        rl_channel = findViewById(R.id.rl_channel);
        txt_channel = findViewById(R.id.channel);
        channel_num = findViewById(R.id.channel_num);
        txt_message = findViewById(R.id.message);
        txt_better = findViewById(R.id.better);
        txt_setting = findViewById(R.id.my);
        ly_content = findViewById(R.id.fl_content);
        txt_channel.setOnClickListener(this);
        txt_message.setOnClickListener(this);
        txt_better.setOnClickListener(this);
        txt_setting.setOnClickListener(this);
    }
    private void setSelected(){
        txt_channel.setSelected(false);
        txt_message.setSelected(false);
        txt_better.setSelected(false);
        txt_setting.setSelected(false);
    }


    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.channel:
                setSelected();
                txt_channel.setSelected(true);
                channel_num.setVisibility(View.VISIBLE);
                break;
        }
        fragmentTransaction.commit();

    }
}
