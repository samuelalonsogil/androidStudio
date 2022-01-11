package com.example.recicledview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.miSoporteVisual> {

    //variables globales necesarias


    private List<String> nameList;

    public MiAdaptador(List<String> nameList) {
        this.nameList = nameList;
    }


    //obtener soporte visual
    @Override
    public MiAdaptador.miSoporteVisual onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //sobreescribir el metodo para prepaar la vista fila

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(  R.layout.fila, parent, false  );
        miSoporteVisual msv =  new miSoporteVisual (view);

        return msv;

    }


    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.miSoporteVisual msv, int position) {
        //sobreescribir para enlazar la vista fila
        //pillo un texto y lo coloco een el textView
        final String text = nameList.get(position);
        msv.textView.setText(text);
    }


    //metodo clasico para contar el numero de elmentos del recicler
    @Override
    public int getItemCount() {
        if(nameList == null){
            return 0;
        }else{
            return nameList.size();
        }

    }

    class miSoporteVisual extends RecyclerView.ViewHolder{
        public TextView textView;

        public miSoporteVisual(@NonNull View itemView) {
            super(itemView);

            //encontramos el textView de la fila y otros elementos si los hay
            this.textView = itemView.findViewById(R.id.fila01);
        }
    }
}
