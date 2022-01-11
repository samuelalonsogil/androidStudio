package com.example.reciclerview02;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.miSoporteVisual>{

    //variables globales necesarias
    ArrayList<Nombres> listaNombres;

    public MiAdaptador(ArrayList<Nombres> listaNombres) {
        this.listaNombres = listaNombres;
    }

    //obtener soporte visual
    @Override
    public MiAdaptador.miSoporteVisual onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //sobreescribir el metodo para prepaar la vista fila

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(  R.layout.fila, parent, false  );
        miSoporteVisual msv = new miSoporteVisual(view);

        return msv;

    }


    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.miSoporteVisual msv, @SuppressLint("RecyclerView") int position) {
        //sobreescribir para enlazar la vista fila
        //pillo un texto y lo coloco een el textView
        msv.nombre.setText(listaNombres.get(position).getNombre());
        msv.capital.setText(listaNombres.get(position).getCapital());

        msv.bandera.setImageResource(listaNombres.get(position).getBandera());

        msv.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                remove(position);
            }
        }

        );
    }


    //metodo clasico para contar el numero de elmentos del recicler
    @Override
    public int getItemCount() {
        if(listaNombres == null){
            return 0;
        }else{
            return listaNombres.size();
        }

    }


    private void remove(int position){
        //elimino item del arrayList
        listaNombres.remove(position);

        //aviso de que quitamos un item del arrayList
        notifyDataSetChanged();
    }

    static class miSoporteVisual extends RecyclerView.ViewHolder{
        public TextView nombre;
        public TextView capital;
        public ImageView bandera;

        public miSoporteVisual(@NonNull View itemView) {
            super(itemView);

            //encontramos el textView de la fila y otros elementos si los hay
            nombre =(TextView) itemView.findViewById(R.id.textView01);
            capital =(TextView) itemView.findViewById(R.id.textView02);
            bandera =(ImageView) itemView.findViewById(R.id.imageView01);
        }
    }

}
