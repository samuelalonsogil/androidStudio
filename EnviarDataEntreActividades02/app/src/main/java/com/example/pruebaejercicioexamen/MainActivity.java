package com.example.pruebaejercicioexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mandarDatos(View view){
        EditText caja = (EditText)findViewById(R.id.datoPasado);

        String texto = caja.getText().toString();
        Intent intent = new Intent(this , SecondActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT , texto);

        //método clave
        startActivity(intent);
    }
}