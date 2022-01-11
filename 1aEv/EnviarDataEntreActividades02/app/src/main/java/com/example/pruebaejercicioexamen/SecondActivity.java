package com.example.pruebaejercicioexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    //necesito recoger una cadena pasada en el intent y enchufarla en el text view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView coloco = (TextView) findViewById(R.id.llegada);
        coloco.setText(extraerDatos() );
    }

    public String extraerDatos(){
        Bundle param = this.getIntent().getExtras();

        String datos=null;
        if (param != null) {
            datos = param.getString(Intent.EXTRA_TEXT);
        }
        return datos;
    }
}