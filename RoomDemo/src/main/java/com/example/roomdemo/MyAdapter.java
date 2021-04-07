package com.example.roomdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * @CreateDate: 2021-4-6 18:59
 * @UpdateDate: 2021-4-6 18:59
 * @Description:
 * @Author: uidq2189
 * @UpdateRemark:
 * @Version: 1.0
 */
public class MyAdapter extends BaseAdapter {
    private List<User> list;
    private Context context;

    public MyAdapter(Context context , List<User> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {

        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        TextView tvId = view.findViewById(R.id.tv_item_id);
        TextView tvName = view.findViewById(R.id.tv_item_name);
        TextView tvAge = view.findViewById(R.id.tv_item_age);
        tvId.setText(String.valueOf(list.get(position).getId()));
        tvName.setText(list.get(position).getName());
        tvAge.setText(String.valueOf(list.get(position).getAge()));
        return view;
    }
}
