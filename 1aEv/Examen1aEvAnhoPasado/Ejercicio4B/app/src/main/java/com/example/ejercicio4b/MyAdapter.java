package com.example.ejercicio4b;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    ArrayList<Estados> estados;
    Context context;
    Intent intent;

    public MyAdapter( Context context, ArrayList<Estados> estados) {
        this.context = context;
        this.estados = estados;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.my_row, parent, false );

        return new MyViewHolder(view);
    }


    //comunicates with myViewHolder
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView01.setText(estados.get(position).getNombre());
        holder.textView02.setText(estados.get(position).getCapital());
        holder.textView03.setText(estados.get(position).getHabitantes());
        holder.textView04.setText(estados.get(position).getExtension());

        holder.imageView01.setImageResource(estados.get(position).getBandera());

        holder.relativeLayout.setOnClickListener(v -> {
            intent = new Intent(context, SecondActivity.class);

            intent.putExtra("nombre", estados.get(position).getNombre() );
            intent.putExtra("capital", estados.get(position).getCapital() );
            intent.putExtra("habitantes", estados.get(position).getHabitantes() );
            intent.putExtra("extension", estados.get(position).getExtension() );
            intent.putExtra("bandera", estados.get(position).getBandera() );

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        if (estados == null) return 0;
        else return estados.size();
    }


    //recive the view from above
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView01, textView02, textView03, textView04;
        ImageView imageView01;
        RelativeLayout relativeLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView01 = itemView.findViewById(R.id.nombre);
            textView02 = itemView.findViewById(R.id.capital);
            textView03 = itemView.findViewById(R.id.poblacion);
            textView04 = itemView.findViewById(R.id.territorio);

            imageView01 = itemView.findViewById(R.id.bandera);

            relativeLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

}
