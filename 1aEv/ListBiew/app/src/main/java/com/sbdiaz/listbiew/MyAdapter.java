package com.sbdiaz.listbiew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Nombres> nombres;

    public MyAdapter(Context context, int layout, ArrayList<Nombres> nombres) {
        this.context = context;
        this.layout = layout;
        this.nombres = nombres;
    }

    @Override
    public int getCount() {
        return this.nombres.size();
    }

    @Override
    public Object getItem(int position) {
        return this.nombres.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.row, null);

        String nombre = nombres.get(position).getName();
        String capital = nombres.get(position).getCapital();
        int image = nombres.get(position).getPhoto();

        TextView textView1 = (TextView) view.findViewById(R.id.nombre);
        textView1.setText(nombre);
        TextView textView2 = (TextView) view.findViewById(R.id.descripcion);
        textView2.setText(capital);
        ImageView imageView = (ImageView) view.findViewById(R.id.imagenCiudad);
        imageView.setImageResource(image);

        return view;
    }
}
