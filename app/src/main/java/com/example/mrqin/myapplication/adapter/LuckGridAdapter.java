package com.example.mrqin.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrqin.myapplication.R;

/**
 * Created by Mrqin on 2018/3/14.
 */

public class LuckGridAdapter extends BaseAdapter {
    private Context context;
    private int[] items;
    private String[] items_more;

    public LuckGridAdapter() {
        super();
    }

    public LuckGridAdapter(Context context, int[] items, String[] items_more) {
        super();
        this.context = context;
        this.items = items;
        this.items_more = items_more;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.luck_grid_list_item, null);
            viewHolder.img = convertView.findViewById(R.id.img);
            viewHolder.text = convertView
                    .findViewById(R.id.text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.img.setImageResource(items[position]);
        viewHolder.text.setText(items_more[position]);
        return convertView;
    }

    static class ViewHolder {
        ImageView img;
        TextView text;
    }
}