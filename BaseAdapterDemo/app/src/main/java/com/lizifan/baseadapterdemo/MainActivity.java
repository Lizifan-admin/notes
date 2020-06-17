package com.lizifan.baseadapterdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView news_title;
    private FrameLayout fl_content;
    private Context context;
    private ArrayList<DateBean> dates;
    private FragmentManager fragmentManager;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        fragmentManager = getSupportFragmentManager();
        init();
        dates = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            DateBean dateBean = new DateBean("新闻标题"+i,i+"新闻内容");
            dates.add(dateBean);
        }
        ListFragmnet listFragmnet = new ListFragmnet(fragmentManager, dates);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_content,listFragmnet);
        fragmentTransaction.commit();

    }
    private void init(){
        news_title = findViewById(R.id.news_title);
        fl_content = findViewById(R.id.fl_content);
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() == 0){
            if ((System.currentTimeMillis() - exitTime) > 2000){
                Toast.makeText(getApplicationContext(),"再按一次退出程序",Toast.LENGTH_LONG).show();
                exitTime = System.currentTimeMillis();
            }else {
                super.onBackPressed();
            }
        }else {
            fragmentManager.popBackStack();
            news_title.setText("新闻列表");
        }
    }
}
