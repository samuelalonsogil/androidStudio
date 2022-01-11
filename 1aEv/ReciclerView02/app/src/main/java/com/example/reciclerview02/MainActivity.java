package com.example.reciclerview02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Nombres> listaNombres;
    RecyclerView recyclerViewNombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaNombres = new ArrayList<>();
        recyclerViewNombres = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewNombres.setLayoutManager(new LinearLayoutManager(this));
        llenarArray();
        MiAdaptador miAdaptador = new MiAdaptador(listaNombres);
        recyclerViewNombres.setAdapter(miAdaptador);

      }

    private void llenarArray() {

        listaNombres.add(new Nombres( "Galicia", "Santiago", R.drawable.galicia));
        listaNombres.add(new Nombres( "Andalucia", "Sevilla", R.drawable.andalucia));
        listaNombres.add(new Nombres( "Asturias", "Oviedo", R.drawable.asturias));
        listaNombres.add(new Nombres("Cantabria","Santader",R.drawable.cantabria));
        listaNombres.add(new Nombres("Euzkadi","Vitoria/Gasteiz",R.drawable.euzkadi));
        listaNombres.add(new Nombres("Navarra","Pamplona",R.drawable.navarra));
        listaNombres.add(new Nombres("Aragon","Zaragoza",R.drawable.aragon));
        listaNombres.add(new Nombres("Cataluña","Barcelona",R.drawable.catalunya));
        listaNombres.add(new Nombres("C. Valenciana","Valencia",R.drawable.valencia));

        listaNombres.add(new Nombres("C Murciana","Murcia",R.drawable.murcia));
        listaNombres.add(new Nombres("Castilla Leon","Valladolid",R.drawable.castillaleon));
        listaNombres.add(new Nombres("Castilla La Mancha","Toledo",R.drawable.castillamancha));
        listaNombres.add(new Nombres("Extremadura","Merida",R.drawable.extremadura));
        listaNombres.add(new Nombres("Canarias","Las Palmas",R.drawable.canarias));
        listaNombres.add(new Nombres("C. Madrid","Madrid",R.drawable.madrid));
        listaNombres.add(new Nombres("La Rioja","Logroño",R.drawable.rioja));
    }
}