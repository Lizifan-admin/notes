package com.lizifan.baseadapterdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class MyAdapter extends BaseAdapter {
    private List<DateBean> lists;
    private Context context;

    public MyAdapter(List<DateBean> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.listitems,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.item_content = convertView.findViewById(R.id.item_content);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.item_content.setText(lists.get(position).getNews());
        return convertView;
    }
    private class ViewHolder{
        TextView item_content;
    }
}
