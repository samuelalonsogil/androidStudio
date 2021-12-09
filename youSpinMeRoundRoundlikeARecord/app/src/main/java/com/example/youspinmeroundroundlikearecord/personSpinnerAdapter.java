package com.example.youspinmeroundroundlikearecord;

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
import java.util.List;

public class personSpinnerAdapter extends ArrayAdapter<Nombres> {

    private Context context;
    private int layout;
    private ArrayList<Nombres> names;

    public personSpinnerAdapter(Context ctx, int layout, ArrayList<Nombres> names) {
        super(ctx, layout, names);
        this.context = ctx;
        this.layout = layout;
        this.names = names;

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return crearFilaPersonalizada(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        return crearFilaPersonalizada(position, convertView, parent);
    }

    private View crearFilaPersonalizada(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.context);
        View miFila = inflater.inflate(R.layout.linea, parent, false);

        TextView nombre = miFila.findViewById(R.id.nombre);
        nombre.setText(names.get(position).getNombre());

        TextView descripcion = miFila.findViewById(R.id.descripcion);
        descripcion.setText(names.get(position).getCapital());

        ImageView imagen = miFila.findViewById(R.id.imagenCiudad);
        imagen.setImageResource(names.get(position).getBandera());

        return miFila;
    }
}