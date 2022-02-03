package com.example.busquedahttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textViewSearch;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();

        /*preparamos el hilo de búsqueda*/
        StrictMode.setThreadPolicy( new StrictMode.ThreadPolicy.Builder().permitNetwork().build() );


    }

    public void search(View view){

        try{
            String textIntroduced = editText.getText().toString();
            String textSearched = googleSearch(textIntroduced);
            textViewSearch.append(textIntroduced + " --> " + textSearched + "\\n")
        
        }catch (Exception e) {
            e.printStackTrace();
        };

    }

    public void initVariables(){
        editText = findViewById(R.id.editText01);
        textViewSearch = findViewById(R.id.editTextSearch);
        button = findViewById(R.id.button01);

    }
}