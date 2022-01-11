package com.example.listviewperso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    public Context context;
    public int layout;
    public ArrayList<Element> elements;
    public LayoutInflater layoutInflater;
    public View view;

    public String name, description;
    public int image;

    public TextView textView01, textView02;
    public ImageView imageView01;

    public MyAdapter(Context context, int layout, ArrayList<Element> elements) {
        this.context = context;
        this.layout = layout;
        this.elements = elements;
    }

    @Override
    public int getCount() {
        return this.elements.size();
    }

    @Override
    public Object getItem(int position) {
        return this.elements.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        view = convertView;
        layoutInflater = LayoutInflater.from(this.context);

        view = layoutInflater.inflate(R.layout.my_row, null);
        name = elements.get(position).getName();
        description = elements.get(position).getDescription();
        image = elements.get(position).getImage();

        textView01 = view.findViewById(R.id.textView01);
        textView01.setText(name);
        textView02 = view.findViewById(R.id.textView02);
        textView02.setText(description);
        imageView01 = view.findViewById(R.id.imageView01);
        imageView01.setImageResource(image);

        return view;
    }
}
