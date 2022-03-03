package com.example.ejerciciosqlnovelas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    EditText title, author,country,editorial,price,year;
    Button button;
    ListView listView;
    SimpleCursorAdapter simpleCursorAdapter;
    Database database;

    public void initVariables(){
        database = new Database(MainActivity.this);
        title = findViewById(R.id.editTextTitle);
        author = findViewById(R.id.editTextAuthor);
        country = findViewById(R.id.editTextCountry);
        editorial = findViewById(R.id.editTextEditorial);
        price = findViewById(R.id.editTextPrice);
        year = findViewById(R.id.editTextYear);
        button = findViewById(R.id.buttonAdd);
        listView= findViewById(R.id.listView01);

        button.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();

    }

    public void saveRecord() {
        database.saveRecord(title.getText().toString(), author.getText().toString(), country.getText().toString(), editorial.getText().toString(),price.getText().toString(),year.getText().toString());
        title.setText("");
        author.setText("");
        country.setText("");
        editorial.setText("");
        price.setText("");
        year.setText("");

        updateNovelList();
    }

    private void updateNovelList() {
        simpleCursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                database.getNovelList(),
                new String[]{"title"},
                new int[]{android.R.id.text1},
                0);
        listView.setAdapter(simpleCursorAdapter);
    }

    @Override
    public void onClick(View view) {
        saveRecord();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}