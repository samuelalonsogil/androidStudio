package com.example.ejercicio4b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView textView01, textView02, textView03, textView04;
    ImageView imageView01;

    String nombre, capital,habitantes, territorio;
    int bandera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        
        initVariables();
        getData();
        setData();
    }

    private void initVariables() {
        textView01 = findViewById(R.id.textView01);
        textView02 = findViewById(R.id.textView02);
        textView03 = findViewById(R.id.textView03);
        textView04 = findViewById(R.id.textView04);

        imageView01 = findViewById(R.id.imageView01);
    }

    public void getData(){
        if (getIntent().hasExtra("bandera" ) && getIntent().hasExtra("nombre" )
            && getIntent().hasExtra("capital" )  && getIntent().hasExtra("habitantes" )
            && getIntent().hasExtra("extension" ) ){

            bandera = getIntent().getIntExtra("bandera", 1);
            nombre = getIntent().getStringExtra("nombre");
            capital = getIntent().getStringExtra("capital");
            habitantes = getIntent().getStringExtra("habitantes");
            territorio = getIntent().getStringExtra("territorio");


        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    public void setData(){
        textView01.setText(bandera);
        textView02.setText(nombre);
        textView03.setText(habitantes);
        textView04.setText(territorio);
        imageView01.setImageResource(bandera);
    }


}