package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Element> {

    TextView textViewName, textViewDescription;
    ImageView picture;

    private Context context;
    private ArrayList<Element> elements;

    public MyAdapter(@NonNull Context context, int layout, @NonNull ArrayList<Element> elements) {
        super(context, layout, elements);
        this.context = context;
        this.elements = elements;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createPersonalizedRow(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createPersonalizedRow(position, convertView, parent);
    }

    private View createPersonalizedRow(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View myRow = inflater.inflate(R.layout.my_row, parent, false);

        textViewName = myRow.findViewById(R.id.textViewItem);
        textViewName.setText(elements.get(position).getName() );
        textViewDescription = myRow.findViewById(R.id.textViewDescription);
        textViewDescription.setText(elements.get(position).getDescription());
        picture = myRow.findViewById(R.id.image01);
        picture.setImageResource(elements.get(position).getImage());

        return myRow;
    }
}
