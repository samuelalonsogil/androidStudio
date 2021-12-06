package com.example.ejercicio04;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<Team> {

    TextView textView01, textView02, textView03, textView04;
    ImageView imageView;
    LayoutInflater layoutInflater;

    public SpinnerAdapter(@NonNull Context context, int resource, @NonNull List<Team> teams) {
        super(context, resource, teams);
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder")
        View rowView = layoutInflater.inflate(R.layout.fila, null, true);

        Team team = getItem(position);
        textView01 = rowView.findViewById(R.id.nameTeam);
        textView01.setText(team.getName());

        textView02 = rowView.findViewById(R.id.country);
        textView02.setText(team.getCountry());

        textView03 = rowView.findViewById(R.id.city);
        textView03.setText(team.getCity());

        textView04 = rowView.findViewById(R.id.year);
        textView04.setText(team.getYear());

        imageView = rowView.findViewById(R.id.imageShield);
        imageView.setImageResource(team.getImages());

        return rowView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) convertView = layoutInflater.inflate(R.layout.fila, parent, false);

        Team team = getItem(position);
        textView01 = convertView.findViewById(R.id.nameTeam);
        textView02 = convertView.findViewById(R.id.country);
        textView03 = convertView.findViewById(R.id.city);
        textView04 = convertView.findViewById(R.id.year);
        imageView = convertView.findViewById(R.id.imageShield);

        imageView.setImageResource(team.getImages());

        return convertView;
    }



}
