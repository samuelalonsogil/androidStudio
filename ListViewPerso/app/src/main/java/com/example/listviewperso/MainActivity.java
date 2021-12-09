package com.example.listviewperso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public ListView listView;
    public ArrayList<Element> elements;
    public MyAdapter myAdapter;

    public TextView textView;
    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        fillArray();
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);

    }

    private void fillArray() {
        elements.add(new Element("Nano sexo", "Nano dios del sexo", R.drawable.nano_sexo));
        elements.add(new Element("Alfredo Duro", "¿Qué es halloween?", R.drawable.alfredo_duro));
        elements.add(new Element("Spider-man triste", "Se le ve triste", R.drawable.spider_man_sad));
    }

    private void initVariables() {
        listView = findViewById(R.id.listView01);
        elements = new ArrayList<Element>();
        myAdapter = new MyAdapter(MainActivity.this, R.layout.my_row, elements);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        textView = findViewById(R.id.nameSelected);
        textView.setText(elements.get(position).getName());

        imageView = findViewById(R.id.imageSelected);
        imageView.setImageResource(elements.get(position).getImage());

        imageView.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
    }
}