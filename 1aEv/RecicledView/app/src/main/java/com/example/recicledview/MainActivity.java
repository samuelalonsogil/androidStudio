package com.example.recicledview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> provincias = new ArrayList<>();

        provincias.add("Betanzos");
        provincias.add("Monforte");
        provincias.add("Cambados");
        provincias.add("Allariz");
        provincias.add("Moaña");
        provincias.add("Cangas");
        provincias.add("Bueu");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //pasamos al gestor recicler
        recyclerView.setLayoutManager(linearLayoutManager);

        //instancias un adaptador
        MiAdaptador miAdaptador = new MiAdaptador(provincias);
        recyclerView.setAdapter(miAdaptador);

    }
}