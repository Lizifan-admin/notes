package com.lizifan.dibudaohangfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment implements View.OnClickListener {
    private Context context;
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_four;

    public MyFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content, container,false);
        btn_one = view.findViewById(R.id.btn_one);
        btn_two = view.findViewById(R.id.btn_two);
        btn_three = view.findViewById(R.id.btn_three);
        btn_four = view.findViewById(R.id.btn_four);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                TextView channel_num = getActivity().findViewById(R.id.channel_num);
                channel_num.setText("35");
                channel_num.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_two:
                TextView message_num = getActivity().findViewById(R.id.message_num);
                message_num.setText("80");
                message_num.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_three:
                TextView better_num = getActivity().findViewById(R.id.better_num);
                better_num.setText("99+");
                better_num.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_four:
                ImageView image = getActivity().findViewById(R.id.my_red);
                image.setVisibility(View.VISIBLE);
                break;
        }

    }
}
