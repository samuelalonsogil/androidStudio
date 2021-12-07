package com.example.ejercicio4b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView01;

    public ArrayList<Estados> estados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estados = new ArrayList<>();
        recyclerView01 = findViewById(R.id.recyclerView01);
        recyclerView01.setLayoutManager(new LinearLayoutManager(this));
        addToarrayList();
        MyAdapter myAdapter = new MyAdapter(this, estados);
        recyclerView01.setAdapter(myAdapter);


    }


    public void addToarrayList(){
        estados.add(new Estados("Eslovaquia", "Bratislava", "5445802", "357022",  R.drawable.bandera_eslovaca ) );
        estados.add(new Estados("Alemania", "Berlin", "80722792", "49035",  R.drawable.bandera_alemania ) );
        estados.add(new Estados("Grecia", "Atenas", "10773253", "131957",  R.drawable.bandera_griega ) );
        estados.add(new Estados("Lituania", "Vilna", "2854235", "65300",  R.drawable.bandera_lituania ) );
        estados.add(new Estados("Portugal", "Lisboa","10833816", "92090",  R.drawable.bandera_portugal ) );
        estados.add(new Estados("Suecia", "Estocolmo","9880604", "450295",  R.drawable.bandera_suecia ) );
    }


}