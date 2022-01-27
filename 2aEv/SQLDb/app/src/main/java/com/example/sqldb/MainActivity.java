package com.example.sqldb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    EditText editTextPalabra, editTextDefinicion;
    DiccionarioDatabase diccionarioDatabase;
    ListView listView;
    Button button01;
    SimpleCursorAdapter simpleCursorAdapter;

    public void initVariables(){
        diccionarioDatabase = new DiccionarioDatabase(MainActivity.this);
        editTextPalabra = findViewById(R.id.editText01);
        editTextDefinicion = findViewById(R.id.editText02);
        button01 = findViewById(R.id.button01);
        listView = findViewById(R.id.listView);
    }

    @Override
    public void onClick(View view) {
        saveRecord();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        editTextPalabra.setText(diccionarioDatabase.getWord(l));
        editTextDefinicion.setText(diccionarioDatabase.getDefinition(l));
        diccionarioDatabase.deleteRecord(l);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(MainActivity.this,
                "Records deleted = " + diccionarioDatabase.deleteRecord(l), Toast.LENGTH_SHORT).show();
        updateWordList();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        button01.setOnClickListener(this);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        updateWordList();
    }

    private void saveRecord() {
        diccionarioDatabase.saveRecord(editTextPalabra.getText().toString(), editTextDefinicion.getText().toString());
        editTextPalabra.setText("");
        editTextDefinicion.setText("");
        updateWordList();
    }

    private void updateWordList() {
         simpleCursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                diccionarioDatabase.getWordList(),
                new String[]{"word"},
                new int[]{android.R.id.text1},
                0);
        listView.setAdapter(simpleCursorAdapter);
    }



}