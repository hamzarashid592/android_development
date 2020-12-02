package com.example.playing_with_adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class BaseAdapterTest extends BaseAdapter {

    Context context;
    int pictures[];
    LayoutInflater inflater;

    public BaseAdapterTest(Context context, int pictures[]){
        this.context=context;
        this.pictures=pictures;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return pictures.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.activity_image__grid,null);
        ImageView flags=(ImageView)convertView.findViewById(R.id.flags);
        flags.setImageResource(pictures[position]);
        return convertView;

    }
}
