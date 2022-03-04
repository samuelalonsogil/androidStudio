package com.example.ejercicio03crud;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, AdapterView.OnItemClickListener {

    EditText editTextId, editTextTitle, editTextAuthor;
    Button buttonAdd, buttonDelete, buttonModify;
    ListView listViewBooks;
    SQLiteDatabase db;
    String[] divided;
    TextView textView01, textView02;

    @SuppressLint("CutPasteId")
    public void initVariables(){
        textView02 = findViewById(R.id.editTextAuthor);
        textView01 = findViewById(R.id.textViewSelected);
        editTextId = findViewById(R.id.editTextId);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextAuthor = findViewById(R.id.editTextAuthor);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonDelete= findViewById(R.id.buttonDelete);
        buttonModify= findViewById(R.id.buttonModify);
        buttonAdd.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonModify.setOnClickListener(this);
        listViewBooks = findViewById(R.id.listViewBooks);
        listViewBooks.setOnItemClickListener(this);
    }

    public void createDatabase(){
        db = openOrCreateDatabase("MyBooks", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS myBooks(_id VARCHAR,Title VARCHAR, Author VARCHAR);");

    }

    public void add(View v) {
        db.execSQL("INSERT INTO MyBooks VALUES" +
                " ('" + editTextId.getText().toString() + "','" + editTextTitle.getText().toString() + "','" + editTextAuthor.getText().toString() + "')");
        Toast.makeText(this, "added: " + editTextTitle.getText().toString(),Toast.LENGTH_LONG).show();
        list();
    }

    public void delete(View v) {
        try {
            db.execSQL("DELETE FROM MyBooks WHERE Title = '" +
                    editTextTitle.getText().toString() + "' AND _id='" + editTextId.getText().toString() + "'");
            Toast.makeText(this, "deleted book: " + editTextTitle.getText().toString(), Toast.LENGTH_LONG).show();
        } catch (SQLException s) {
            Toast.makeText(this, "error deleting", Toast.LENGTH_LONG).show();
        }
        list();
    }

    public void modify(View v){

        db.execSQL("UPDATE myBooks SET _id='"+ editTextId.getText().toString()+"', Title='"+
                editTextTitle.getText().toString()+"', Author='"+ editTextAuthor.getText().toString()+"' WHERE _id='"+ editTextId.getText().toString()+"'");
        Toast.makeText(this,"modified book:  "+editTextTitle.getText().toString(),Toast.LENGTH_LONG).show();
        list();
    }

    public void list(){
        ArrayAdapter<String> adapter;
        List<String> list = new ArrayList<String>();

        Cursor c=db.rawQuery("SELECT * FROM MyBooks", null);
        if(c.getCount()==0)
            list.add("no data");
        else{
            while(c.moveToNext()) {
                list.add(c.getString(0) + "-" + c.getString(1) + "-" + c.getString(2));
            }
        }
        adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.lista_fila,list);
        listViewBooks.setAdapter(adapter);
        c.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        createDatabase();
        list();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == buttonAdd.getId() ) add(view);
        else if ( view.getId() == buttonDelete.getId() ) delete(view);
        else if ( view.getId() == buttonModify.getId() ) modify(view);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String string;

        string=adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(),"Title => "+string, Toast.LENGTH_SHORT).show();
        divided=string.split("-");


        editTextId.setText(divided[0]);
        editTextTitle.setText(divided[1]);
        editTextAuthor.setText(divided[2]);
    }
}