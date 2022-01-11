package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView textViewSelected;
    ImageView imageViewSelected;
    Spinner spinner;
    ArrayList<Element> elements;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initValues();
        addValues();
        myAdapter = new MyAdapter(this, R.layout.my_row, elements);
        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void addValues() {
        elements.add(new Element("Florentino Sexo", "un mafias pero se le ve fachero", R.drawable.florentino_sexo));
        elements.add(new Element("Ramos", "traidor", R.drawable.ramos));
        elements.add(new Element("Un actor", "no me acuerdo del nombre ahora", R.drawable.mentally_ill));
    }

    private void initValues() {
        textViewSelected = findViewById(R.id.itemSelected);
        imageViewSelected = findViewById(R.id.imageSelected);
        spinner = findViewById(R.id.spinner01);

        elements = new ArrayList<Element>();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        textViewSelected.setText(elements.get(position).getName());
        //textViewSelected.setVisibility(View.VISIBLE);
        imageViewSelected.setImageResource(elements.get(position).getImage());
        //imageViewSelected.setVisibility(View.VISIBLE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}