package com.lizifan.dialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_dialog_one;
    private Button btn_dialog_two;
    private Button btn_dialog_three;
    private Button btn_dialog_four;
    private Context mContext;
    private Dialog dialog1;
    private boolean[] checkItems;
    private AlertDialog.Builder builder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
        mContext = MainActivity.this;
        bindView();
    }
    private void bindView(){
        btn_dialog_one = findViewById(R.id.btn_dialog_one);
        btn_dialog_two = findViewById(R.id.btn_dialog_two);
        btn_dialog_three = findViewById(R.id.btn_dialog_three);
        btn_dialog_four = findViewById(R.id.btn_dialog_four);
        btn_dialog_one.setOnClickListener(this);
        btn_dialog_four.setOnClickListener(this);
        btn_dialog_three.setOnClickListener(this);
        btn_dialog_two.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dialog_one:
                builder = new Builder(mContext);
                builder.setTitle(R.string.title1);
                builder.setMessage(R.string.message);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext,R.string.suer,Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext,R.string.cancel,Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setCancelable(false);
                dialog1 = builder.create();
                dialog1.show();
                break;
            case R.id.btn_dialog_two:
                builder = new Builder(mContext);
                final String[] language = new String[]{"Android","Java","C++","Javascript",".net","IOS","Linux"};
                builder.setTitle(R.string.title2);
                builder.setItems(language, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext,"我喜欢"+language[which],Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setCancelable(false);
                dialog1 = builder.create();
                dialog1.show();
                break;
            case R.id.btn_dialog_three:
                builder = new Builder(mContext);
                final String[] fruits = new String[]{"苹果","香蕉","橘子","芒果","番茄","屎"};
                builder.setTitle(R.string.title3);
                builder.setSingleChoiceItems(fruits,0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext,"我喜欢吃"+fruits[which],Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setCancelable(true);
                dialog1 = builder.create();
                dialog1.show();
                break;
            case R.id.btn_dialog_four:
                builder = new Builder(mContext);
                final String[] games = new String[]{"英雄联盟","王者荣耀","绝地求生","逆水寒","堡垒之夜"};
                checkItems =new  boolean[]{false,false,false,false,false};
                builder.setCancelable(false);
                builder.setTitle(R.string.title4);
                builder.setMultiChoiceItems(games, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkItems[which] = isChecked;
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = "";
                        for (int i = 0;i<checkItems.length;i++){
                            if (checkItems[i]){
                                result += games[i]+"";
                            }
                        }
                        Toast.makeText(mContext,"我喜欢玩"+result,Toast.LENGTH_SHORT).show();
                    }
                });

//                builder.setCancelable(true);
                dialog1 = builder.create();
                dialog1.show();
                break;



        }
    }
}
