package com.lizifan.baseadapterdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ListFragmnet extends Fragment implements AdapterView.OnItemClickListener {
    private FragmentManager fragmentManager;
    private List<DateBean> beans;
    private ListView list_news;

    public ListFragmnet(FragmentManager fragmentManager, List<DateBean> beans) {
        this.fragmentManager = fragmentManager;
        this.beans = beans;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listview_fg,container,false);
        list_news = view.findViewById(R.id.list_news);
        MyAdapter myAdapter = new MyAdapter(beans, getActivity());
        list_news.setAdapter(myAdapter);
        list_news.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ContentFragment contentFragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("content",beans.get(position).getContent());
        contentFragment.setArguments(bundle);
        TextView item_content = getActivity().findViewById(R.id.item_content);
        item_content.setText(beans.get(position).getNews());
        fragmentTransaction.replace(R.id.fl_content,contentFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
